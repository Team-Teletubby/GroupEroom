package com.eroom.gw.workStatus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.workStatus.domain.WorkStatus;
import com.eroom.gw.workStatus.service.logic.WorkStatusService;

@Controller
public class workStatusController {

	@Autowired
	private WorkStatusService workStatusService;
	
	// 로그인 ID의 부서와
	@RequestMapping(value="showMemberStatus.do", method=RequestMethod.POST)
	public void showMemberStatus(@ModelAttribute WorkStatus workstatus,HttpSession session, HttpServletResponse response) {
		Member member = (Member)session.getAttribute("LoginUser");
		System.out.println(member.getMemberDept());
		
		
	}
}
