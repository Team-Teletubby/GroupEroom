package com.eroom.gw.attendance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String attendanceList(Model model, HttpSession session){
		Member LoginUser = (Member)session.getAttribute("LoginUser");
		int memberId = LoginUser.getMemberId();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String now = format.format(new Date()); //달력 용도
		int totalHoliday = 0;
		Date today = (new Date());
		Date regDate = LoginUser.getRegDate();
		
		long baseDay = 24 * 60 * 60 * 1000;
		long baseMonth = baseDay * 30;	
		long baseYear = baseMonth * 12;
		long calDate = today.getTime() - regDate.getTime();
		
		long diffDate = calDate / baseDay;
		long diffMonth = calDate / baseMonth;
		long diffYear = calDate / baseYear;
				
		if(diffYear < 1) {
			totalHoliday = 11;
		} else if(diffYear <= 2) {
			totalHoliday = 15;
		} else if(diffYear <= 4) {
			totalHoliday = 16;
		} else if(diffYear <= 6) {
			totalHoliday = 17;
		} else if(diffYear <= 8) {
			totalHoliday = 18;
		} else if(diffYear <= 10) {
			totalHoliday = 19;
		} else if(diffYear <= 12) {
			totalHoliday = 20;
		} else if(diffYear <= 14) {
			totalHoliday = 21;
		} else if(diffYear <= 16) {
			totalHoliday = 22;
		} else if(diffYear <= 18) {
			totalHoliday = 23;
		} else if(diffYear <= 20) {
			totalHoliday = 24;
		} else if(diffYear <= 22) {
			totalHoliday = 25;
		} else if(diffYear <= 24) {
			totalHoliday = 26;
		} else if(diffYear <= 26) {
			totalHoliday = 27;
		} else if(diffYear <= 28) {
			totalHoliday = 28;
		} else if(diffYear <= 30) {
			totalHoliday = 29;
		} //for문으로 어케 바꾸
		
		float usedHoliday = atdService.usedHolidayCount(memberId);
		float restHoliday = totalHoliday-usedHoliday;
		model.addAttribute("usedHoliday", usedHoliday);
		model.addAttribute("totalHoliday", totalHoliday);
		model.addAttribute("restHoliday", restHoliday);
		model.addAttribute("diffDate", diffDate);
		model.addAttribute("now", now);
		return "attendance/attendanceList";
	}
	
	// 연차 기록 전체 출력
	public ModelAndView atdListView(ModelAndView mv,@RequestParam("")int memberId) {
		return mv;
	}
	
	// 연차 등록
	@RequestMapping(value="attendanceRegister.do" ,method=RequestMethod.POST)
	public ModelAndView atdRegister(ModelAndView mv, @ModelAttribute Attendance attendance, @RequestParam("restHoliday")float restHoliday,HttpServletResponse response ) throws IOException {
		int calDate = (int) (attendance.getEndDate().getTime() - attendance.getStartDate().getTime() );
		int calDiff = (calDate / (24*60*60*1000))+1;
		attendance.setUsedHoliday(calDiff);
		float usedHoliday = attendance.getUsedHoliday();
		float diff = restHoliday - usedHoliday;
		System.out.println(diff);
		int result = atdService.registerAttendance(attendance);
		if(result>0 && diff>=0) {
			mv.setViewName("redirect:attendanceList.do");
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
