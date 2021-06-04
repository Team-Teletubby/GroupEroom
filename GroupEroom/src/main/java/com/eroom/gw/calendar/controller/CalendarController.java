package com.eroom.gw.calendar.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.service.CalendarService;
import com.eroom.gw.member.domain.Member;

@Controller
public class CalendarController {

	@Autowired
	private CalendarService calService;
	
//	@RequestMapping(value="calendarListView.do")
//	public String calendarView() {
//		return "calendar/calendar";
//		
//	}
	
//	// 내 일정 전체 출력
//	@RequestMapping(value="calendarListView.do")
//	public String calListView(HttpSession session, Model model) {
//		Member member = (Member)session.getAttribute("LoginUser");
//		int memberId = member.getMemberId();
//		ArrayList<Calendar> calList = calService.selelctAllCal(memberId);
//		model.addAttribute("calList",calList);
//		return "calendar/calendar";
//		/*
//		 * if(!calList.isEmpty()) { }else { return ""; }
//		 */
//		
//	}
	
	
	// 내 일정 전체 출력
	@RequestMapping(value="calendarListView.do")
	public String calListView(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("LoginUser");
		int memberId = member.getMemberId();
		ArrayList<Calendar> calList = calService.selelctAllCal(memberId);
		System.out.println(calList);
		model.addAttribute("calList",calList);
		return "calendar/calendar";
		/*
		 * if(!calList.isEmpty()) { }else { return ""; }
		 */
		
	}
	
	
	
	// 일정 상세보기
	public ModelAndView calDetailView(ModelAndView mv, @RequestParam("")int calNo) {
		return mv;
	}
	
	// 일정 등록
	@RequestMapping(value="registerCal.do", method=RequestMethod.POST)
	public String calRegister(HttpSession session,
								@RequestParam(value="calTitle") String calTitle,
								@RequestParam(value="startDate")String startDate,
								@RequestParam(value="endDate")String endDate,
								@RequestParam(value="calInfo")String calInfo,
								@RequestParam(value="startTime")String startTime,
								@RequestParam(value="endTime")String endTime,
								@RequestParam(value="color")String color
								){
		Member member = (Member)session.getAttribute("LoginUser");
		Calendar calendar = new Calendar();
		if(!(startTime =="")) {
			startDate = startDate + "T" + startTime;
		}
		if(!(endTime =="")) {
			endDate = endDate + "T" + endTime;
		}
		calendar.setMemberId(member.getMemberId());
		calendar.setCalTitle(calTitle);
		calendar.setCalInfo(calInfo);
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		calendar.setColor(color);
		int result = calService.registerCal(calendar);
		if(result>0) {
			return "redirect:calendarListView.do";
		}else {
			return "";
		}
	}
	
	// 일정 수정
	public ModelAndView calModify(ModelAndView mv, @ModelAttribute Calendar calendar) {
		return mv;
	}
	
	// 일정 삭제
	public String calRemove(Model model, @RequestParam("") int calNo) {
		return null;
		
	}
//	주석을 잘 달자..
	
}
