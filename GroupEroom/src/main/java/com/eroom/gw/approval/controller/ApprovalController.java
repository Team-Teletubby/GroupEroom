package com.eroom.gw.approval.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.service.ApprovalService;

@Controller
public class ApprovalController {
	
	@Autowired
	private ApprovalService approvalService;
	
	// 멤버 정보 가져오기
	public void getMemberinfo() {
		
		// 세션에 저장된 정보 가져와서 객체에 저장해서 반환
		
		// 나중에 return형 member로 바꾸기
	}
	
	// 결재 페이지로 이동
	@RequestMapping(value="approvalWriteView.do", method=RequestMethod.GET)
	public String  approvalWriteView() {
		return "approval/approvalWriteForm";
	}
	
	// 결재글 등록 
	@RequestMapping(value="approvalRegister.do", method=RequestMethod.POST)
	public ModelAndView approvalRegister(ModelAndView mv,
									@ModelAttribute Approval approval,
									@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
									HttpServletRequest request) {
		
		return mv;
	}
	
	// 글 목록보기 (페이징 처리도)
	public ModelAndView approvalList(ModelAndView mv,
									@RequestParam(value="page", required=false)Integer page) {
		
		return mv;
	}
	
	// 글 상세보기
	@RequestMapping(value="approvalDetail.do", method=RequestMethod.GET)
	public ModelAndView approvalDetail(ModelAndView mv,
									@RequestParam("approvalNo")int approvalNo) {
		// 글 번호에 맞는 정보 가져오기
		// 결제 상태 변경 메소드 사용하기 (조건문 사용)
		return mv;
}

	// 결재 상태 변경 (진행함에서 결제자가 글을 봤을 경우,
	// 반려, 승인 버튼을 눌렀을 경우 / 페이지에서 상태값 가져오기(heddin))
	public void approvalState(int approvalNo, String approvalState) {
		
	}
	
	// 결재 삭제
	@RequestMapping(value="deleteApproval.do", method=RequestMethod.GET)
	public String deleteApproval(@RequestParam("approvalNo")int approvalNo) {
		
		return "redirect:approvalList.do";
	}
	
	// ======================================================
	
	// 댓글
	
	// ======================================================
	// 검색 
	
}
