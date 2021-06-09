package com.eroom.gw.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.approval.service.ApprovalService;
import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Pagination;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;
import com.sun.media.jfxmedia.logging.Logger;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private ApprovalService approvalService;

	// 로그인 -> 메인페이지 연결
	@GetMapping(value="index.do")
	public ModelAndView mainView(ModelAndView mv, HttpSession session) { 
		Member member = (Member)session.getAttribute("LoginUser");
		int memberId = member.getMemberId();
		// 나에게 온 결재문 갯수 
		int approvalTypeCount = approvalService.printTypeCount(memberId);
		mv.addObject("approvalTypeCount", approvalTypeCount);
		// 회원 정보
		mv.addObject("member", member);
		
		mv.setViewName("index");
		
		return mv;
	}
	
	
//로그인 

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public String memberLogin(Model model, @ModelAttribute Member mem, HttpServletRequest request) {

		Member member = new Member(mem.getMemberId(), mem.getMemberPwd());
		Member selectOne = service.loginMember(member);
		String url = "";
		if (selectOne == null) {
			
			model.addAttribute("msg", "아이디나 비밀번호가 틀립니다.");
			return "login";
		} else {
		
			if (selectOne.getMemberPwd().equals("1234")) {
				model.addAttribute("memberId", member.getMemberId());
				url = "pwdChange";
				
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("LoginUser", selectOne);
				url = "redirect:index.do";
			}
			
		}
		return url;
	}

	// 로그아웃
	@RequestMapping(value = "logout.do", method = RequestMethod.GET)
	public String memberLogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:index";
	}



	// 사원등록 폼 연결

	@RequestMapping(value = "enrollView.do", method = RequestMethod.GET)
	public String enrollView() {
		return "member/memberForm";
	}
	
	// 성공페이지 연결 
	 @RequestMapping(value="success.do", method=RequestMethod.GET)
	 public ModelAndView joinSuccess(@ModelAttribute Member member, HttpServletResponse response, HttpServletRequest request, ModelAndView mv) throws Exception {
		 request.setCharacterEncoding("utf-8");
		 System.out.println(member.getMemberName());
		try {
		
			Member resultMember = service.printSuccessMemberOne(member);
			mv.addObject("selectOne", resultMember).setViewName("member/joinSuccess");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", "등록실패").setViewName("common/errorPage");
		}
	
		return mv;		
	 }

	// 사원등록
	@RequestMapping(value = "memberRegister.do", method = RequestMethod.POST)
	public String memberRegister(@ModelAttribute Member member, @RequestParam("post") String post,
			@RequestParam("address1") String address1, @RequestParam("address2") String address2,
			@RequestParam("email1") String email1, @RequestParam("email2") String email2,
			@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile, HttpServletRequest request,
			@RequestParam("Rrn1") String Rrn1, @RequestParam("Rrn2") String Rrn2, HttpServletResponse response  ) throws Exception {
		response.setContentType("text/html; charset=utf-8");
		 request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		System.out.println(member.getMemberName());
			System.out.println("들어옴");
		if (!uploadFile.getOriginalFilename().equals("")) {
			String renameFileName = saveFile(uploadFile, request);
			if (renameFileName != null) {
				member.setOriginalFileName(uploadFile.getOriginalFilename());
				member.setRenameFileName(renameFileName);
			}
		}
		member.setMemberName(member.getMemberName());
		member.setMemberAddr(post + "," + address1 + "," + address2);
		member.setMemberEmail(email1 + "@" + email2);
		member.setMemberRrn(Rrn1 + "-" + Rrn2);
		int result = service.registerMember(member);
		String path = "";
		
		if (result > 0) {
			return "redirect:success.do?memberName=" + URLEncoder.encode(member.getMemberName(), "utf-8") + "&memberRrn=" + member.getMemberRrn();
		} else {
			return "common/errorPage";
		}
	}

	private String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		// 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\memberproFile";
		System.out.println(savePath);

		// 폴더생성
		File folder = new File(savePath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = uploadFile.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis())) + "."
				+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		String filePath = folder + "\\" + renameFileName;
		// 저장
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return renameFileName;
	}

	// 정보수정뷰 뷰
	@RequestMapping(value = "info.do", method = RequestMethod.GET)
	public ModelAndView memberModifyView(ModelAndView mv, @RequestParam("memberId") int memberId) {
		Member member = service.printMemberOne(memberId);
		System.out.println(member.toString());
		if (member != null) {
			mv.addObject("memberOne", member).setViewName("member/memberUpdate");
		} else {
			mv.addObject("msg", "멤버 상세조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	// 사원 정보수정

	@RequestMapping(value = "memberModify.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView modifyMember(ModelAndView mv, @ModelAttribute Member member, Model model,
			HttpServletRequest request, @RequestParam("post") String post, @RequestParam("address1") String addr1,
			@RequestParam("address2") String addr2,
			@RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile) {

		System.out.println("test" + member.getMemberId());
		// 프로필 수정
		if (reloadFile != null && !reloadFile.isEmpty()) {
			if (member.getRenameFileName() != "") {
				deleteFile(member.getRenameFileName(), request);
			}
			// 다시 업로드
			String renameFileName = saveFile(reloadFile, request);
			if (renameFileName != null) {
				member.setOriginalFileName(reloadFile.getOriginalFilename());
				member.setRenameFileName(renameFileName);
			}
		}

		String addr = post + "," + addr1 + "," + addr2;
		member.setMemberAddr(addr);
		int result = service.modifyMember(member);
		System.out.println(result);
		if (result > 0) {
			mv.setViewName("redirect:memberList.do");
		} else {
			mv.addObject("msg", "정보수정실패").setViewName("common/errorPage");
		}
		return mv;
	}

	// 프로필 사진 삭제
	private void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\memberproFile";
		System.out.println(savePath);
		File file = new File(savePath + "\\" + fileName);
		if (file.exists()) {
			file.delete();
		}

	}

	// 사원 목록조회
	@RequestMapping(value = "memberList.do", method = RequestMethod.GET)
	public String memberList(Model model, @RequestParam(value = "page", required = false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = service.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Member> mlist = service.printAll(pi);
		model.addAttribute("mlist", mlist);
		model.addAttribute("pi", pi);
		return "member/memberlist";
	}

	// 사원 상세 조회
	@GetMapping(value = "memberDetail.do")
	public String memberDetail(@RequestParam("memberId") int memberId, Model model) {
		Member member = service.printMemberOne(memberId);

		if (member != null) {
			model.addAttribute("memberOne", member);
			return "member/memberDetailView";
		} else {
			model.addAttribute("msg", "사원상세조회 실패");
			return "common/errorPage";
		}
	}

	// 사원 검색
	@RequestMapping(value = "memberSearch.do", method = RequestMethod.GET)
	public String memberSearch(@ModelAttribute Search search, Model model,
			@RequestParam(value = "page", required = false) Integer page) {
		System.out.println(search);
		int currentPage = (page != null) ? page : 1;
		int listCount = service.getSearchListCount(search);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Member> searchList = service.printSearchAll(search, pi);
		if (!searchList.isEmpty()) {
			model.addAttribute("mlist", searchList);
			model.addAttribute("pi", pi);
			model.addAttribute("search", search);
			return "member/memberlist";
		}
		model.addAttribute("msg", "사원검색 실패");
		return "common/errorPage";
	}

	// 이메일 중복체크
	@ResponseBody
	@RequestMapping(value = "emChk.do", method = RequestMethod.GET)
	public String idDuplicateCheck(@RequestParam("memberEmail") String memberEmail) {
		memberEmail = memberEmail + "@teletubby.co.kr";
		return String.valueOf(service.checkemId(memberEmail));

	}

	// 비밀번호 변경
	@RequestMapping(value = "pwdChange.do", method= RequestMethod.POST)
	public String pwdChange(@ModelAttribute Member member, Model model) {
		int result = service.modifymemberPwd(member);
		if (result > 0) {
			return "index";
		} else {
			model.addAttribute("message", "변경하실 비밀번호를 다시한번 확인해주세요.");
			return "pwdChange";

		}
	}
		//  비밀번호 중복
		@ResponseBody
		@RequestMapping(value ="pwdCheck.do", method=RequestMethod.POST)
		public String pwdCheck(@RequestParam("memberPwd")String memberPwd , Member member, @RequestParam("Password1") String Password1,@RequestParam("Password2")String Password2) { 
			 member.setMemberPwd(Password1+Password2);
			return String.valueOf(service.pwdcheck(memberPwd));
		}
	}


