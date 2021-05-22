package com.eroom.gw.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
//로그인 
	@RequestMapping(value="login.do" , method=RequestMethod.POST)
	public String memberLogin(Model model , @ModelAttribute Member member , HttpServletRequest request ) {
		
		Member result = service.loginMember(member);
		
		if(result == null) { 
			model.addAttribute("msg", "아이디나 비밀번호가 틀립니다.");
			return "login";
		}else { 
			HttpSession session = request.getSession();
			session.setAttribute("memberId", result.getMemberId());
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
	 
	 
	 // 사원등록 폼 연결 
	
	@RequestMapping(value="enrollView.do", method=RequestMethod.GET)
	public String enrollView() { 
		return "member/memberForm";
	}
	// 사원등록
		@RequestMapping(value="memberRegister.do", method= {RequestMethod.POST , RequestMethod.GET})
		public String memberRegister(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2, Model model, @RequestParam(required= false)) { 
		
			member.setMemberAddr(post+","+address1+","+address2);
			int result = service.registerMember(member);
			if(result >0) {
				return "redirect:index";
				
			}else {
				model.addAttribute("msg" , "사원등록실패");
				return "index";
			}
			
	}
	// 인사관리 뷰 
	
	@RequestMapping(value="Info.do", method=RequestMethod.GET)  
	public String infoView() { 
		return "";
	}
	// 사원 정보수정 
	@RequestMapping(value="memberModify.do", method=RequestMethod.POST)
	public String modifyMember(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2, Model model, HttpServletRequest request) {
	
		return "";
	}
	//사원 목록조회
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public String memberList(Model model) { 
		List<Member> list = service.printAll();
		model.addAttribute("list", list);
		
		return "member/memberlist";
	}
	
	// 사원 검색 
	@RequestMapping(value="memberSearch.do", method=RequestMethod.GET)
	public String memberSearch(@ModelAttribute Search search,Model model) {
		return "";
	}
}

