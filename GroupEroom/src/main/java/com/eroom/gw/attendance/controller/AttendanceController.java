package com.eroom.gw.attendance.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import com.eroom.gw.member.domain.Member;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService atdService;
	
	@RequestMapping(value="attendanceList.do")
	public String attendanceList(Model model){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(new Date());
		model.addAttribute("now", now);
		return "attendance/attendanceList";
	}
	
	// 연차 기록 전체 출력
	public ModelAndView atdListView(ModelAndView mv,@RequestParam("")int memberId) {
		return mv;
	}
	
	// 연차 등록
	public ModelAndView atdRegister(ModelAndView mv, @ModelAttribute Attendance attendance) {
		int result = atdService.registerAttendance(attendance);
		if(result>0) {
			mv.setViewName("attendance/attendanceList");
		}else {
			mv.setViewName("error");
		}
		return mv;
	}
	
	// 연차 삭제(취소)
	public String atdRemove(Model model, @RequestParam("") int attendanceNo) {
		return null;
		
	}
	
}
