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
		public String memberRegister(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1, @RequestParam("address2") String address2, Model model ) { 
		
			member.setMemberAddr(post+","+address1+","+address2);
			int result = service.registerMember(member);
			if(result >0) {
				return "index";
				
			}else {
				model.addAttribute("msg" , "사원등록실패");
				return "index";
			}
			
	}
	// 정보수정뷰 뷰 
	
	@GetMapping(value="memberModifyForm.do")
	public String infoView(@RequestParam("memberId")int memberId, Model model) {
		Member member = service.printMemberOne(memberId);
		
		if(member!=null) {
			model.addAttribute("memberOne",member);
			return "member/memberModify";
		}else {
			return "index";
		}
	}
	// 사원 정보수정 
	@RequestMapping(value="memberModify.do" , method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyMember(@ModelAttribute Member member, @RequestParam("post") String post, @RequestParam("address1") String address1 ,@RequestParam("address2") String address2 ,
							 Model model, HttpServletRequest request) {
		System.out.println("postmapping 들어옴");
		
		member.setMemberAddr(post +", "+address1+", "+address2);
		int result = service.modifyMember(member);
		
		if(result > 0) { 
			return "redirect:memberList.do";
		}else {
			return "";
		}
		
	}
	//사원 목록조회
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public String memberList(Model model) { 
		List<Member> list = service.printAll();
		model.addAttribute("list", list);
		
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
			return "member/errorPage";
		}
	}
	// 사원 검색 
	@RequestMapping(value="memberSearch.do", method=RequestMethod.GET)
	public String memberSearch(@ModelAttribute Search search,Model model) {
		return "";
	}
}

