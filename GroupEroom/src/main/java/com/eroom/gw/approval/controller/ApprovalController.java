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
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalFile;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.service.ApprovalService;
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
			@RequestParam(value = "uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request) {
		
		ApprovalFile aFile = new ApprovalFile(); 		// 파일 정보 저장하는 객체
		HttpSession session = request.getSession(); 		// 세션에 등록된 로그인 정보 가져오기
		Member member = (Member)session.getAttribute("loginMember"); 		// 멤버 객체에 세션 저장
		approval.setMemberId(member.getMemberId()); 		// 세션에 저장된 멤버ID값 결재 객체에 저장
		
		// jsp에서 uploadFile 정보를 가져 왔다면
		if(!uploadFile.getOriginalFilename().contentEquals("")) {
			String reNameFileName = saveFile(uploadFile, request); 			// 파일 이름을 시간으로 변환하고 서버에 저장
			// 변환이 성공하면
			if(reNameFileName != null) {
				aFile.setOriginalFileName(uploadFile.getOriginalFilename()); 				// 객체에 저장
				aFile.setReNameFileName(reNameFileName);
			}
		}
		int resultApproval = approvalService.registerApproval(approval); 		// DB에 결재글 등록
		int resultFile = approvalService.registerFile(aFile); 		// DB에 파일 정보 등록
		
		String path = ""; 		
		if(resultApproval > 0) { // DB 저장여부 확인 후, 페이지 이동
			path = "";
		}else {
			mv.addObject("msg", "결재등록or파일등록 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}

	// 글 List 보기 (페이징 처리도)
	public ModelAndView approvalList(ModelAndView mv, @RequestParam(value="page", required=false)Integer page,
									@RequestParam(value="boardType")String boardType) {

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
		 * 1 : 인사관리, 2 : IT개발팀, 3 : 재무팀
		 */
		String depName = "";
		
		switch(depType) {
		case 1:
			depName = "인사관리팀";
			break;
		case 2:
			depName = "IT개발팀";
			break;
		case 3:
			depName = "재무팀";
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
	public String saveFile(MultipartFile file, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources"); // resources 폴더 위치 저장
		String savePath = root + "\\approvalFiles"; // 파일 저장할 폴더 이름
		File folder = new File(savePath); // 저장 폴더 선택
		if(!folder.exists()) { // 폴더 없으면 자동 생성
			folder.mkdir(); 
		}
		
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
