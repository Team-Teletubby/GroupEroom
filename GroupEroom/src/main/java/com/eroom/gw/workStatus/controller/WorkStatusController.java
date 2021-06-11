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
import com.eroom.gw.workStatus.service.WorkStatusService;
import com.eroom.gw.workStatus.service.logic.WorkStatusServiceImpl;

@Controller
public class WorkStatusController {

	@Autowired
	private WorkStatusService workStatusService;
	
	@RequestMapping(value="workStatusRegister.do", method=RequestMethod.POST)
	public void workStatusRegister(@ModelAttribute WorkStatus workStatus) {

		int insertResult = workStatusService.registerWorkMember(workStatus);
		
	}
	
	
	// 상태 변화
	@RequestMapping(value="changeCeoStatus.do", method=RequestMethod.POST)
	public void change(@ModelAttribute WorkStatus workstatus) {
		
		
		
	}
}
