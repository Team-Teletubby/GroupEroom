package com.eroom.gw.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;




import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;

@Controller
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
	//로그인
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, @ModelAttribute Member member, Model model) {
		
		return "index";
		
	}
	
	//회면가입 
	
	@RequestMapping(value="enrollView.do", method=RequestMethod.GET)
	public String enrollView() { 
		return "";
	}
	// 사원등록
	@RequestMapping(value="memberRegister.do", method=RequestMethod.POST)
		public String memberRegister(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2, Model model) {
		 return "";
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
	//사원 조회 
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public String memberList(Model model) { 
	
		return "";
	}
	
	// 사원 검색 
	@RequestMapping(value="memberSearch.do", method=RequestMethod.GET)
	public String memberSearch(@ModelAttribute Search search,Model model) {
		return "";
	}
}

