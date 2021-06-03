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
	public ModelAndView approvalWriteView(ModelAndView mv, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("LoginUser");
		mv.addObject("loginUser", member);
		mv.setViewName("approval/approvalWrite");
		
		return mv;
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
	public ModelAndView progressList(ModelAndView mv, 
									HttpServletRequest request,
									@RequestParam(value="page", required=false)Integer page) {
		// 세션에서 로그인한 정보 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("LoginUser");
		// 결재 객체에 로그인/상태 정보 저장
		Approval approval = new Approval();
		approval.setMemberId(member.getMemberId());
		// 진행함으로 들어가기 위한 문장
		String state = "progress";
		approval.setApprovalState(state);
		System.out.println(approval.getApprovalState());
		
		//======================== 글 페이징 ========================
		// jsp에 page가 존재할 경우, 1로 변경
		int currentPage = (page != null) ? page : 1;
		// 진행함 게시판 타입
		int listCount = approvalService.getListCount(approval);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		//===========================================================
		//======================== 글 리스트 ========================
		System.out.println("로그인한 유저id : " + approval.getMemberId());
		// 글 목록 가져오기
		ArrayList<Approval> aList = approvalService.printAll(pi, approval);
		//===========================================================
		
		mv.addObject("aList", aList);
		mv.addObject("userName", member.getMemberName());
		mv.addObject("page", page);
		mv.setViewName("approval/progressListView");
		
		return mv;
	}
	
	// 미결함 List 보기
	@RequestMapping(value="suspenseBoard.do", method=RequestMethod.GET)
	public ModelAndView suspenseList(ModelAndView mv,
									HttpServletRequest request,
									@RequestParam(value="page", required=false)Integer page) {
		
		// 세션에서 로그인한 정보 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("LoginUser");
		// 결재 객체에 로그인/상태 정보 저장
		Approval approval = new Approval();
		approval.setMemberId(member.getMemberId());
		// 미결함으로 들어가기 위한 문장
		String state = "suspense";
		approval.setApprovalState(state);
		//======================== 글 페이징 ========================
		// jsp에 page가 존재할 경우, 1로 변경
		int currentPage = (page != null) ? page : 1;
		int listCount = approvalService.getListCount(approval);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		//===========================================================
		//======================== 글 리스트 ========================
		// 글 목록 가져오기
		ArrayList<Approval> aList = approvalService.printAll(pi, approval);
		//===========================================================
				
		mv.addObject("aList", aList);
		mv.addObject("userName", member.getMemberName());
		mv.addObject("page", page);
		mv.setViewName("approval/suspenseListView");
				
		return mv;
	}
	
	// 완료함 List 보기
	@RequestMapping(value="completeBoard.do", method=RequestMethod.GET)
	public ModelAndView completeList(ModelAndView mv,
									HttpServletRequest request,
									@RequestParam(value="page", required=false)Integer page) {
		
		// 세션에서 로그인한 정보 가져오기
				HttpSession session = request.getSession();
				Member member = (Member)session.getAttribute("LoginUser");
				// 결재 객체에 로그인/상태 정보 저장
				Approval approval = new Approval();
				approval.setMemberId(member.getMemberId());
				// 미결함으로 들어가기 위한 문장
				String state = "complete";
				approval.setApprovalState(state);
				//======================== 글 페이징 ========================
				// jsp에 page가 존재할 경우, 1로 변경
				int currentPage = (page != null) ? page : 1;
				int listCount = approvalService.getListCount(approval);
				PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
				//===========================================================
				//======================== 글 리스트 ========================
				// 글 목록 가져오기
				ArrayList<Approval> aList = approvalService.printAll(pi, approval);
				//===========================================================
						
				mv.addObject("aList", aList);
				mv.addObject("userName", member.getMemberName());
				mv.addObject("page", page);
				mv.setViewName("approval/completeListView");
						
				return mv;
	}
	
	// 반려함 List 보기
		@RequestMapping(value="rejectBoard.do", method=RequestMethod.GET)
		public ModelAndView rejectList(ModelAndView mv,
										HttpServletRequest request,
										@RequestParam(value="page", required=false)Integer page) {
			
			// 세션에서 로그인한 정보 가져오기
					HttpSession session = request.getSession();
					Member member = (Member)session.getAttribute("LoginUser");
					// 결재 객체에 로그인/상태 정보 저장
					Approval approval = new Approval();
					approval.setMemberId(member.getMemberId());
					// 미결함으로 들어가기 위한 문장
					String state = "reject";
					approval.setApprovalState(state);
					//======================== 글 페이징 ========================
					// jsp에 page가 존재할 경우, 1로 변경
					int currentPage = (page != null) ? page : 1;
					int listCount = approvalService.getListCount(approval);
					PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
					//===========================================================
					//======================== 글 리스트 ========================
					// 글 목록 가져오기
					ArrayList<Approval> aList = approvalService.printAll(pi, approval);
					//===========================================================
							
					mv.addObject("aList", aList);
					mv.addObject("userName", member.getMemberName());
					mv.addObject("page", page);
					mv.setViewName("approval/rejectListView");
				
					return mv;
		}
	
	// 글 상세보기
	@RequestMapping(value="approvalDetail.do", method=RequestMethod.GET)
	public ModelAndView approvalDetail(ModelAndView mv, 
									@RequestParam("approvalNo")int approvalNo,
									HttpServletRequest request) {
		System.out.println("디테일 메소드 실행중");
		// 세션 정보 가져오기
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("LoginUser");
		// 글 상세보기 가져오기
		Approval approval = approvalService.printOne(approvalNo);
		if(approval != null) {
			// 결재문 상태 변경하기 (해당 결재와 연관있는 결재자)
			viewStateChange(approval, member);
			mv.addObject("approval", approval);
			System.out.println(approval.getMemberId());
			mv.addObject("loginUserId", member.getMemberId());
			mv.setViewName("approval/approvalDetail");
		}else {
			System.out.println("글 상세보기 오류");
		}
		return mv;
	}
	
	// 결재자가 버튼을 눌렀을 경우
	@RequestMapping(value="compleBtn.do")
	public String completeBtn(HttpSession session, @ModelAttribute Approval approval) {
		System.out.println("compleBtn 진입");
		Member member = (Member)session.getAttribute("LoginUser");
		// 승인 버튼을 눌렀을 경우
		System.out.println(approval.getApprovalState());
		if(approval.getApprovalState().equals("C")) {
			System.out.println("중간 결재자 if문 진입");
			// 중간 결재자
			if(member.getMemberId() == approval.getApprovalFirstId()) {
				System.out.println("중간 결재자 if-if문 진입");
				approval.setApprovalState("C1");
				int result = approvalService.changeCheck(approval);
				if(result > 0) {
					System.out.println("수정완료");
				}else {
					System.out.println("수정 실패");
				}
			// 최종 결재자
			}else if(member.getMemberId() == approval.getApprovalSecondId()) {
				approval.setApprovalState("C2");
				int result = approvalService.changeCheck(approval);
			}
		// 반려 버튼을 눌렀을 경우
		}else if(approval.getApprovalState().equals("R")) {
			int result = approvalService.changeState(approval);
		}
		return "redirect:suspenseBoard.do";
	}
	
	// 결재 상태 변경 (미결함에서 결제자가 글을 봤을 경우)
	public void viewStateChange(Approval approval, Member member) {
		// 변경할 상태값을 저장하는 변수
		String changeState = "";
		// 미결함에서 결제자가 글을 봤을 경우
		if(approval.getApprovalState().equals("N")) {
			if(approval.getApprovalFirstId() == member.getMemberId() || approval.getApprovalSecondId() == member.getMemberId()) {
				changeState = "I";
				approval.setApprovalState(changeState);
				int result = approvalService.changeState(approval);
			}
		}
	}
	
	// 결재 삭제
	@RequestMapping(value="approvalDelete.do", method=RequestMethod.GET)
	public String approvalDelete(@ModelAttribute Approval approval) {
		int result = approvalService.changeState(approval);
		return "redirect:progressBoard.do";
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
	@RequestMapping(value="replyList.do", method=RequestMethod.POST)
	public void replyList(@RequestParam("approvalNo")int approvalNo, HttpServletResponse response) throws JsonIOException, IOException {
		
		ArrayList<ApprovalReply> replyList = approvalService.printAllReply(approvalNo);
		if(replyList != null) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(replyList, response.getWriter());
		}else {
			System.out.println("댓글 리스트 못가져옴");
		}
	}

	// 댓글 등록
	@ResponseBody
	@RequestMapping(value="replyRegister.do", method=RequestMethod.POST)
	public String replyRegister(@ModelAttribute ApprovalReply reply, HttpSession session) {
		// 세션에서 로그인 정보 가져오기
		Member member = (Member)session.getAttribute("LoginUser");
		// 댓글 객체에 로그인 ID값 저장
		reply.setMemberId(member.getMemberId());
		// 댓글 등록
		int result = approvalService.registerReply(reply);
		
		return "success";
	}
	
	// 댓글 수정
	@RequestMapping(value="replyModify.do", method=RequestMethod.GET)
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
