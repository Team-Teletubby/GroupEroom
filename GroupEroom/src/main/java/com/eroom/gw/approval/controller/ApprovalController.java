package com.eroom.gw.approval.controller;

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

@Controller
public class ApprovalController {

	@Autowired
	private ApprovalService approvalService;

	// 멤버 정보 가져오기 (게시글 이동할 때 사용)
	public void getMemberinfo() {

		// 세션에 저장된 정보 가져와서 객체에 저장해서 반환

		// 나중에 return형 member로 바꾸기
	}

	// 결재 페이지로 이동
	@RequestMapping(value = "approvalWriteView.do", method=RequestMethod.GET)
	public String approvalWriteView() {
		return "approval/approvalWrite";
	}

	// 결재글 등록
	@RequestMapping(value = "approvalRegister.do", method=RequestMethod.POST)
	public ModelAndView approvalRegister(ModelAndView mv, @ModelAttribute Approval approval,
			@RequestParam(value = "uploadFile", required=false) MultipartFile uploadFile,
			HttpServletRequest request) {
		// 파일 정보 저장하는 객체
		ApprovalFile aFile = new ApprovalFile();
		
		// jsp에서 uploadFile 정보를 가져 왔다면
		if(!uploadFile.getOriginalFilename().contentEquals("")) {
			// 파일 이름을 시간으로 변환하고 서버에 저장
			String reNameFileName = saveFile(uploadFile, request);
			// 변환이 성공하면
			if(reNameFileName != null) {
				// 객체에 저장
				aFile.setOriginalFileName(uploadFile.getOriginalFilename());
				aFile.setReNameFileName(reNameFileName);
			}
		}
		// DB에 결재글 등록
		int resultApproval = approvalService.registerApproval(approval);
		// DB에 파일 정보 등록
		int resultFile = approvalService.registerFile(aFile);
		
		// DB 저장여부 확인 후, 페이지 이동
		String path = "";
		if(resultApproval > 0) {
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
	public String fileSave(MultipartFile file, HttpServletRequest request) {
		
		return "";
	}
	
	// 파일 삭제
	public void fileDelete(String fileName, HttpServletRequest request) {
		
	}
}
