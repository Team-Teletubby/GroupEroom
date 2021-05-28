package com.eroom.gw.mail.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.service.MailService;
import com.eroom.gw.member.domain.Member;

@Controller
public class MailController {
	
	@Autowired
	private MailService mService;
	
	//받은 메일함
	@RequestMapping(value="inboxListView.do")
	public ModelAndView inboxListView(ModelAndView mv, @ModelAttribute Mail mail, 
									HttpServletRequest request, HttpSession session, 
									@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1; //페이지 대응시키기
		int listCount = mService.getListCount(); //전체 게시글 개수
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		mail.setReceiverId(loginUser.getMemberId());
		int receiverId = mail.getReceiverId();

		ArrayList<Mail> mailList = mService.printAllInbox(pi, receiverId);
		if(!mailList.isEmpty()) {
			mv.addObject("mailList", mailList);
			mv.addObject("pi", pi);
			mv.setViewName("mail/inboxListView");
		}else {
			mv.addObject("msg", "메일조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	//보낸 메일함
	@RequestMapping(value="sentListView.do")
	public ModelAndView sentListView(ModelAndView mv, @ModelAttribute Mail mail, 
									HttpServletRequest request, HttpSession session, 
									@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1; //페이지 대응시키기
		int listCount = mService.getListCount(); //전체 게시글 개수
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		mail.setSenderId(loginUser.getMemberId());
		int senderId = mail.getSenderId();

		ArrayList<Mail> mailList = mService.printAllSentMail(pi, senderId);
		if(!mailList.isEmpty()) {
			mv.addObject("mailList", mailList);
			mv.addObject("pi", pi);
			mv.setViewName("mail/sentListView");
		}else {
			mv.addObject("msg", "메일조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	//휴지통
	@RequestMapping(value="trashListView.do")
	public ModelAndView trashListView(ModelAndView mv, @ModelAttribute Mail mail, 
									HttpServletRequest request, HttpSession session, 
									@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1; //페이지 대응시키기
		int listCount = mService.getListCount(); //전체 게시글 개수
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		mail.setReceiverId(loginUser.getMemberId());
		int receiverId = mail.getReceiverId();

		ArrayList<Mail> mailList = mService.printAllTrash(pi, receiverId);
		if(!mailList.isEmpty()) {
			mv.addObject("mailList", mailList);
			mv.addObject("pi", pi);
			mv.setViewName("mail/trashListView");
		}else {
			mv.addObject("msg", "메일조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	

}
