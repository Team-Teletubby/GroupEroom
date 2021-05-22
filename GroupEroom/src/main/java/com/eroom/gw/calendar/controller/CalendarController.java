package com.eroom.gw.calendar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.service.CalendarService;

@Controller
public class CalendarController {

	@Autowired
	private CalendarService calService;
	
	@RequestMapping(value="calendarListView.do")
	public String calendarView() {
		return "calendar/calendar";
		
	}
	
	// 내 일정 전체 출력
	public ModelAndView calListView(ModelAndView mv,@RequestParam("")int memberId) {
		return mv;
	}
	
	// 일정 상세보기
	public ModelAndView calDetailView(ModelAndView mv, @RequestParam("")int calNo) {
		return mv;
	}
	
	// 일정 등록
	public ModelAndView calRegister(ModelAndView mv, @ModelAttribute Calendar calendar) {
		return mv;
		
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
