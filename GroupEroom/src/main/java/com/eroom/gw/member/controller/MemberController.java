package com.eroom.gw.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;
import com.sun.media.jfxmedia.logging.Logger;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
//로그인 
	@RequestMapping(value="login.do" , method=RequestMethod.POST)
	public String memberLogin(Model model , @ModelAttribute Member mem , HttpServletRequest request ) {
		
		Member member = new Member(mem.getMemberId(), mem.getMemberPwd());
		Member selectOne = service.loginMember(member);

		if(selectOne == null) { 
			model.addAttribute("msg", "아이디나 비밀번호가 틀립니다.");
			return "login";
		}else { 
			HttpSession session = request.getSession();
			session.setAttribute("LoginUser", selectOne);
			
			return "index";
		}
			
		}

	
			
			
	// 로그아웃
	 @RequestMapping(value="logout.do", method=RequestMethod.GET)
	 public String memberLogOut(HttpServletRequest request) { 
		 HttpSession session = request.getSession();
		 session.invalidate();
		 return "redirect:index";
	 }
	 
	 // 사원등록에서 홈으로 클릭시 홈으로 연결 
	
	 @RequestMapping(value="index.do", method=RequestMethod.GET)
	 public String indexView() { 
		 return "index";
	 }
	 
	 
	 // 사원등록 폼 연결 
	
	@RequestMapping(value="enrollView.do", method=RequestMethod.GET)
	public String enrollView() { 
		return "member/memberForm";
	}
	
	
	// 사원등록
	@RequestMapping(value="memberRegister.do", method=RequestMethod.POST )
	public String memberRegister(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2, @RequestParam("email1") String email1, @RequestParam("email2") String email2, Model model ) { 
	
		member.setMemberAddr(post+","+address1+","+address2);
		member.setMemberEmail(email1+"@"+email2);
		int result = service.registerMember(member);
		if(result >0) {
			return "redirect:memberList.do";

		}else {
			model.addAttribute("msg" , "사원등록실패");
			return "common/errorPage";
		}
			
	}
	// 정보수정뷰 뷰 
	@RequestMapping(value="info.do", method=RequestMethod.GET)
	public ModelAndView memberModifyView(ModelAndView mv, @RequestParam("memberId") int memberId) {
		Member member = service.printMemberOne(memberId);
		System.out.println(member.toString());
		if(member != null) { 
			mv.addObject("memberOne", member).setViewName("member/memberUpdate");
		}else {
			mv.addObject("msg", "멤버 상세조회 실패").setViewName("common/errorPage");
		}
		return mv;
	}
	// 사원 정보수정 
	
	@RequestMapping(value="memberModify.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView modifyMember(ModelAndView mv, @ModelAttribute Member member,
							 Model model, HttpServletRequest request,
							 @RequestParam("post") String post,
							@RequestParam("address1") String addr1,
							@RequestParam("address2") String addr2) {
		
		String addr = post + "," + addr1 + "," + addr2;
		member.setMemberAddr(addr);
		int result = service.modifyMember(member);
		System.out.println(result);
		if(result > 0) {
			mv.setViewName("redirect:memberList.do");
		}else {
			mv.addObject("msg","정보수정실패").setViewName("common/errorPage");
		}
		return mv;
	}
	//사원 목록조회
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public String memberList(Model model) { 
		ArrayList<Member> mlist = service.printAll();
		model.addAttribute("mlist", mlist);
		
		return "member/memberlist";
	}
	
	
	// 사원 상세 조회 
	@GetMapping(value="memberDetail.do")
	public String memberDetail(@RequestParam("memberId") int memberId, Model model) {
		Member member = service.printMemberOne(memberId);
		
		if(member !=null) {
			model.addAttribute("memberOne", member);
			return "member/memberDetailView";
		}else {
			model.addAttribute("msg", "사원상세조회 실패");
			return "common/errorPage";
		}
	}
	// 사원 검색 
	@RequestMapping(value="memberSearch.do", method=RequestMethod.GET)
	public String memberSearch(@ModelAttribute Search search,Model model) {
		System.out.println(search);
		ArrayList<Member> searchList = service.printSearchAll(search);
		if(!searchList.isEmpty()) {
			model.addAttribute("mlist", searchList);
			model.addAttribute("search", search);
			return "member/memberlist";
		}
		model.addAttribute("msg", "사원검색 실패");
		return "common/errorPage";
	}
}

