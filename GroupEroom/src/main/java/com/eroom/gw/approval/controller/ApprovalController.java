package com.eroom.gw.approval.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalFile;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.service.ApprovalService;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.common.Search;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.service.MemberService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Controller
public class ApprovalController {

	@Autowired
	private ApprovalService approvalService;
	@Autowired
	private MemberService memberService;

	// 멤버 정보 가져오기 (게시글 이동할 때 사용)
	public void getMemberinfo() {

		
		// 나중에 return형 member로 바꾸기
	}

	// 결재 페이지로 이동
	@RequestMapping(value = "approvalWriteView.do", method=RequestMethod.GET)
	public String approvalWriteView() {
		return "approval/approvalWrite";
	}

	// 결재 등록
	@RequestMapping(value = "approvalRegister.do", method=RequestMethod.POST)
	public ModelAndView approvalRegister(ModelAndView mv, @ModelAttribute Approval approval,
			MultipartHttpServletRequest mtfRequest,
			HttpServletRequest request) {
		
		ApprovalFile aFile = new ApprovalFile(); 		// 파일 정보 저장하는 객체
		HttpSession session = request.getSession(); 		// 세션에 등록된 로그인 정보 가져오기
		Member loginUser = (Member)session.getAttribute("LoginUser"); 		// 멤버 객체에 세션 저장
		approval.setMemberId(loginUser.getMemberId());		// 세션에 저장된 멤버ID값 결재 객체에 저장

		int resultApproval = approvalService.registerApproval(approval); 		// DB에 결재글 등록
		
		String root = request.getSession().getServletContext().getRealPath("resources"); // resources 폴더 위치 저장
		String savePath = root + "\\approvalFiles"; // 파일 저장할 폴더 이름
		File folder = new File(savePath); // 저장 폴더 선택
		if(!folder.exists()) { // 폴더 없으면 자동 생성
			folder.mkdir(); 
		}
		
		// jsp에서 uploadFile 정보를 가져오기 (다중 파일)
		List<MultipartFile> multFileList = mtfRequest.getFiles("uploadFile");
		
		for(MultipartFile mf : multFileList) {
			aFile.setOriginalFileName(mf.getOriginalFilename()); // 실제 파일명 저장
			aFile.setReNameFileName(saveFile(mf, folder, request)); // 실제 파일 저장, 바뀐 이름 반환
			aFile.setApprovalFileSize(mf.getSize()); // 파일 크기
			aFile.setApprovalFilePath(folder + "\\" + aFile.getReNameFileName());
			int resultFile = approvalService.registerFile(aFile); // DB에 파일 정보 등록
			
			if(resultFile > 0) {
				System.out.println("파일 저장 성공");
			}else {
				System.out.println("파일 저장 실패");
			}
			
		}
		
		String path = ""; 		
		if(resultApproval > 0) { // DB 저장여부 확인 후, 페이지 이동
			path = "index";
		}else {
			mv.addObject("msg", "결재등록or파일등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

	// 진행함 List 보기
	@RequestMapping(value="progressBoard.do", method=RequestMethod.GET)
	public ModelAndView approvalList(ModelAndView mv, 
									HttpServletRequest request,
									@RequestParam(value="page", required=false)Integer page) {
		//======================== 글 페이징 ========================
		// jsp에 page가 존재할 경우, 1로 변경
		int currentPage = (page != null) ? page : 1;
		// 진행함 게시판 타입
		String boardType = "N";
		int listCount = approvalService.getListCount(boardType);
		System.out.println("가져온 글 갯수 : " + listCount);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		//===========================================================
		
		//======================== 글 리스트 ========================
		// 세션에 저장된 멤버객체 가져오기
		HttpSession session = request.getSession();
		Member user = (Member)session.getAttribute("LoginUser");
		// DB에서 사용할 로그인한 ID값을 Approval객체에 저장
		Approval approval = new Approval();
		approval.setMemberId(user.getMemberId());
		// 글 목록 가져오기
		ArrayList<Approval> aList = approvalService.printAll(pi, approval);
		//===========================================================
		if(!aList.isEmpty()) {
			mv.addObject("aList", aList);
			mv.addObject("userName", user.getMemberName());
			mv.addObject("page", page);
			mv.setViewName("approval/progressListView");
		}
		return mv;
	}

	// 글 상세보기
	@RequestMapping(value="approvalDetail.do", method=RequestMethod.GET)
	public ModelAndView approvalDetail(ModelAndView mv, @RequestParam("approvalNo")int approvalNo) {
		// 글 번호에 맞는 정보 가져오기
		// 결제 상태 변경 메소드 사용하기 (조건문 사용)
		return mv;
	}

	// 결재 상태 변경 (진행함에서 결제자가 글을 봤을 경우,
	// 반려, 승인 버튼을 눌렀을 경우 / 페이지에서 상태값 가져오기(heddin))
	public void approvalState(Approval approval) {
//		int approvalNo, String approvalState 사용
	}

	// 결재 삭제
	@RequestMapping(value="approvalDelete.do", method=RequestMethod.GET)
	public String approvalDelete(@RequestParam("approvalNo")int approvalNo) {

		return "redirect:approvalList.do";
	}
	
	// 특정 부서 멤버 목록 조회
	@RequestMapping(value="departmentMember.do", method=RequestMethod.POST)
	public void departmentSelect(@RequestParam("depType")int depType,
								HttpServletResponse response) throws JsonIOException, IOException {
		/*
		 * 1 : 인사관리, 2 : IT개발, 3 : 재무, 4 : 영업
		 */
		String depName = "";
		
		switch(depType) {
		case 1:
			depName = "인사관리";
			break;
		case 2:
			depName = "IT개발";
			break;
		case 3:
			depName = "재무";
			break;
		case 4:
			depName = "영업";
			break;
		}
		ArrayList<Member> mList = memberService.printdepartMentMemberAll(depName);
		
		if(!mList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(mList, response.getWriter());
		}else {
			System.out.println("부서별 회원 조회 실패(데이터없음)");
		}
	}
	
	// ======================================================
	// ======================================================
	// ======================================================
	
	// 댓글 List 보기
	@RequestMapping(value="replyList.do", method=RequestMethod.GET)
	public void replyList(@RequestParam("approvalNo")int approvalNo, HttpServletResponse response) {

		// json으로 보내기
	}

	// 댓글 등록
	@ResponseBody
	@RequestMapping(value="replyRegister", method=RequestMethod.GET)
	public String replyRegister(@ModelAttribute ApprovalReply reply, HttpSession session) {
		
		return "success";
	}
	
	// 댓글 수정
	@RequestMapping(value="replyModify", method=RequestMethod.GET)
	public void replyModity(@ModelAttribute ApprovalReply reply,
							HttpServletResponse response) {
		
		// json으로 보내
	}
	
	// 댓글 삭제
	public String replyDelete(@ModelAttribute ApprovalReply reply, Model model) {
		
		return "success";
	}
	// ======================================================
	// ======================================================
	// ======================================================
	
	// 검색
	@RequestMapping(value="approvalSearch.do", method=RequestMethod.GET)
	public String approvalSearch(@ModelAttribute Search search, Model model) {
		
		return "";
	}

	// ======================================================
	// ======================================================
	// ======================================================
	
	// 파일 저장
	public String saveFile(MultipartFile file, File folder, HttpServletRequest request) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // 파일명 변경하기
		String originalFileName = file.getOriginalFilename();
		String reNameFileName = sdf.format(new Date(System.currentTimeMillis()))
				+ "." + originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String filePath = folder + "\\" + reNameFileName;
		// 파일 저장
		try {
			file.transferTo(new File(filePath));
		} catch (Exception e) {
			System.out.println("결재 파일 저장 오류");
		}
		
		return reNameFileName; 	// 바뀐 파일명 반환
	}
	
	// 파일 삭제
	public void fileDelete(String fileName, HttpServletRequest request) {
		
	}
}
