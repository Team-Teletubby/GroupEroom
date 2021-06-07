package com.eroom.gw.mail.controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.service.MailService;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.service.MemberService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Controller
public class MailController {
	
	@Autowired
	private MailService mService;
	@Autowired
	private MemberService memberService;
	
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
		if(mail != null && "Y".equals(mail.getTrashYn())) { //휴지통인 경우
			mv.addObject("mail", mail);
			mv.setViewName("mail/trashmailDetailView");
		}else if(mail != null && "N".equals(mail.getTrashYn())) { //휴지통이 아닌 경우
			mv.addObject("mail", mail);
			mv.setViewName("mail/mailDetailView");
		}else {
			mv.addObject("msg", "메일 상세조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}

//메일함 to 휴지통
	@RequestMapping(value="moveToTrash.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView moveTrash(ModelAndView mv, HttpServletRequest request, @RequestParam("mailNo") int mailNo,
								@ModelAttribute Mail mail) {
		mail.setMailNo(mailNo);
		int result = mService.moveToTrash(mail);
		if(result > 0 && mailNo % 2 == 1) {
			mv.setViewName("redirect:inboxListView.do");
		}else if(result > 0 && mailNo % 3 == 1){
			mv.setViewName("redirect:sentListView.do");
		}else {
			mv.addObject("msg", "휴지통으로 이동 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
//휴지통 to 메일함
	@RequestMapping(value="returnToMailbox.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView returnToMailbox(ModelAndView mv, HttpServletRequest request, @RequestParam("mailNo") int mailNo,
								@ModelAttribute Mail mail) {
		mail.setMailNo(mailNo);
		int result = mService.returnToMailbox(mail);
		if(result > 0) {
			mv.setViewName("redirect:inboxListView.do");
		}else {
			mv.addObject("msg", "휴지통으로 이동 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	
	
//메일 등록화면단
	@RequestMapping(value="mailComposeView.do")
	public String fBoardWriteView() {
		return "mail/composeMailView";
	}
		
//메일쓰기
	@RequestMapping(value="composeMail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView composeMail(ModelAndView mv, @ModelAttribute Mail mail,
									MultipartHttpServletRequest mhsq,
									HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
		request.setCharacterEncoding("UTF-8");
		session = request.getSession();
		Member loginUser = (Member)session.getAttribute("LoginUser");
		mail.setSenderId(loginUser.getMemberId());
		
		int receiveResult = 0;
		int sendResult = 0;
		String path = "";
		receiveResult = mService.composeMailReceive(mail); //홀수
		sendResult = mService.composeMailSend(mail); //짝수
		if(receiveResult > 0 && sendResult > 0) {
			path = "redirect:inboxListView.do";
		}else {
			mv.addObject("msg", "메일발송 실패");
			path = "common/errorPage";
		}
		
		//멀티파일
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "/mailUploadFiles";
		//저장폴더
		File folder = new File(savePath);
		//폴더가 없으면 자동생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("uploadFile");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")	) {
			
		} else {
			for (int i=0 ; i < mf.size(); i++ ) {
				//파일 중복명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				//원파일명
				String originalFilename = mf.get(i).getOriginalFilename();
				//파일명 재설정
				String renameFilename = sdf.format(new Date(System.currentTimeMillis()))
											+ "." + originalFilename.substring(originalFilename.lastIndexOf(".")+1);
				//파일경로&사이즈
				String filePath = folder + "/" + renameFilename;
				long fileSize = mf.get(i).getSize();
				//파일저장
				mf.get(i).transferTo(new File(filePath));
				mService.fileUpload(originalFilename, renameFilename, filePath, fileSize);
			}
		}
		
		mv.setViewName(path);
		return mv;
	}
//메일작성 시 멤버목록 조회하기(멤버이용)
	@RequestMapping(value="deptMember.do", method=RequestMethod.POST)
	public void deptMember(@RequestParam("depType") int depType,
							HttpServletResponse response) throws JsonIOException, IOException {
		//1.인사관리, 2.영업, 3.재무, 4.IT개발
		String deptName = "";
		switch(depType) {
			case 1: 
				deptName = "인사관리";
				break;
			case 2:
				deptName = "영업";
				break;
			case 3:
				deptName = "재무";
				break;
			case 4:
				deptName = "IT개발";
				break;
		}
		ArrayList<Member> mList = memberService.printMemberUsedDept(deptName);
		if(!mList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(mList, response.getWriter());
		}else {
			System.out.println("데이터 조회 실패");
		}
	}
	
	

}
