package com.eroom.gw.attendance.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.attendance.service.AttendanceService;
import com.eroom.gw.calendar.domain.Calendar;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService atdService;
	
	@RequestMapping(value="attendanceList.do")
	public String attendanceList() {
		return "attendance/attendanceList";
	}
	
	// 연차 기록 전체 출력
	public ModelAndView atdListView(ModelAndView mv,@RequestParam("")int memberId) {
		return mv;
	}
	
	// 연차 등록
	public ModelAndView atdRegister(ModelAndView mv, @ModelAttribute Attendance attendance) {
		return mv;
	}
	
	// 연차 삭제(취소)
	public String atdRemove(Model model, @RequestParam("") int attendanceNo) {
		return null;
		
	}
	
}
