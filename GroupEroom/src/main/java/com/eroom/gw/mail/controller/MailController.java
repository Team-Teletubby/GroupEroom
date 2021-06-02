package com.eroom.gw.mail.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
//휴지통리스트
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
	
//메일상세조회
	@RequestMapping(value="mailDetailView.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mailDetailView(ModelAndView mv, @RequestParam("mailNo") int mailNo) {
		//조회수 증가
		mService.addReadCount(mailNo);
		//파일 불러오기
//		List<MailFile> fileList = mService.printFiles(mailNo);
		//상세조회 불러오기
		Mail mail = mService.printOne(mailNo);
		System.out.println(mail.toString());
		if(mail != null) {
			mv.addObject("mail", mail);
			mv.setViewName("mail/mailDetailView");
		}else {
			mv.addObject("msg", "메일 상세조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
//게시글 등록화면단
	@RequestMapping(value="ComposeMailView.do")
	public String fBoardWriteView() {
		return "mail/composeMailView";
	}
		
//메일쓰기
	@RequestMapping(value="composeMail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView composeMail(ModelAndView mv, @ModelAttribute Mail mail,
									HttpServletRequest request, HttpSession session) throws IOException {
		request.setCharacterEncoding("UTF-8");
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		mail.setSenderId(loginUser.getMemberId());
		
		int receiveResult = 0;
		int sendResult = 0;
		String path = "";
		receiveResult = mService.composeMailReceive(mail);
		sendResult = mService.composeMailSend(mail);
		if(receiveResult > 0 && sendResult > 0) {
			path = "redirect:inboxListView.do";
		}else {
			mv.addObject("msg", "메일발송 실패");
			path = "common/errorPage";
		}
		mv.setViewName(path);
		return mv;
	}
	

}
