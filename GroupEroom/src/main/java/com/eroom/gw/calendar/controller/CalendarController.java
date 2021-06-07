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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.service.CalendarService;
import com.eroom.gw.member.domain.Member;

@Controller
public class CalendarController {

	@Autowired
	private CalendarService calService;

	// 내 일정 전체 출력
	@RequestMapping(value = "calendarListView.do")
	public String calListView(HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("LoginUser");
		int memberId = member.getMemberId();
		ArrayList<Calendar> calList = calService.selelctAllCal(memberId);
		model.addAttribute("calList", calList);
		return "calendar/calendar";
	}

	// 일정 등록
	@RequestMapping(value = "registerCal.do", method = RequestMethod.POST)
	public String calRegister(HttpSession session, @RequestParam(value = "regCalTitle") String calTitle,
			@RequestParam(value = "regStartDate") String startDate, @RequestParam(value = "regEndDate") String endDate,
			@RequestParam(value = "regCalInfo") String calInfo, @RequestParam(value = "regStartTime") String startTime,
			@RequestParam(value = "regEndTime") String endTime, @RequestParam(value = "colors") String color) {
		Member member = (Member) session.getAttribute("LoginUser");
		Calendar calendar = new Calendar();
		if (!(startTime == "")) {
			startDate = startDate + "T" + startTime;
		}
		if (!(endTime == "")) {
			endDate = endDate + "T" + endTime;
		}
		calendar.setMemberId(member.getMemberId());
		calendar.setCalTitle(calTitle);
		calendar.setCalInfo(calInfo);
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		calendar.setColor(color);
		int result = calService.registerCal(calendar);
		if (result > 0) {
			return "redirect:calendarListView.do";
		} else {
			return "";
		}
	}

	// 일정 수정
	@RequestMapping(value = "modifyCal.do", method = RequestMethod.POST)
	public String calModify(@RequestParam(value = "calTitle") String calTitle, @RequestParam(value="calNo") String calNum,
			@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate,
			@RequestParam(value = "calInfo") String calInfo, @RequestParam(value = "startTime") String startTime,
			@RequestParam(value = "endTime") String endTime, @RequestParam(value = "color") String color) {
		
		Calendar calendar = new Calendar();
		if (!(startTime == "")) {
			startDate = startDate + "T" + startTime;
		}
		if (!(endTime == "")) {
			endDate = endDate + "T" + endTime;
		}
		int calNo = Integer.parseInt(calNum);
		calendar.setCalNo(calNo);
		calendar.setCalTitle(calTitle);
		calendar.setCalInfo(calInfo);
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		calendar.setColor(color);
		int result = calService.modifyCal(calendar);
		if (result > 0) {
			return "redirect:calendarListView.do";
		} else {
			return "";
		}
	}

	// 일정 삭제
	@RequestMapping(value = "deleteCal.do")
	public String calRemove(Model model, @RequestParam("calNo") String calNum) {
		int calNo = Integer.parseInt(calNum);
		int result = calService.removeCal(calNo);
		if(result>0) {
			return "redirect:calendarListView.do";
		}else {
			return "";
		}

	}
	
	@ResponseBody
	@RequestMapping(value="updateDate.do", method = RequestMethod.POST)
	public String updateDate(Model model, @RequestParam("startDate")String startDate, @RequestParam("endDate")String endDate, @RequestParam("calNo") String calNum) {
		int calNo = Integer.parseInt(calNum);
		Calendar calendar = new Calendar();
		calendar.setStartDate(startDate);
		calendar.setEndDate(endDate);
		calendar.setCalNo(calNo);
		System.out.println(startDate);
		System.out.println(endDate);
		int result = calService.updateDate(calendar);
		if( result>0) {
			return "success";
		} else {
			return "fail";
		}
		
	}

}
