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
import com.eroom.gw.attendance.domain.Pagination;
import com.eroom.gw.attendance.service.AttendanceService;
import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.service.CalendarService;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.member.domain.Member;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService atdService;
	
	@Autowired
	private CalendarService calService;
	
	
	//근태 리스트 출력
	@RequestMapping(value="attendanceList.do")
	public String attendanceList(Model model, HttpSession session, @RequestParam(value="page", required=false)Integer page){
		Member LoginUser = (Member)session.getAttribute("LoginUser");
		int memberId = LoginUser.getMemberId(); //로그인 아이디
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
				
		System.out.println(diffYear);
		System.out.println(diffMonth);
		System.out.println(diffDate);
		if(diffYear < 1) {
			for(int i=0; i<diffMonth+1; i++) {
				totalHoliday = i;
			}
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
		
		int currentPage = (page !=null) ? page : 1;
		int listCount = atdService.getListCount(memberId);
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Attendance> list = atdService.selectAllAttendance(pi,memberId);
		if(!list.isEmpty()) {
			model.addAttribute("atdList",list);
			model.addAttribute("pi",pi);
		}
		atdService.updateDone();
		float usedHoliday = atdService.usedHolidayCount(memberId); //사용한 연차수
		float restHoliday = totalHoliday-usedHoliday; // 남은 연차 수 
		model.addAttribute("usedHoliday", usedHoliday);
		model.addAttribute("totalHoliday", totalHoliday);
		model.addAttribute("restHoliday", restHoliday);
		model.addAttribute("diffDate", diffDate);
		model.addAttribute("now", now);
		return "attendance/attendance";
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
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = new Calendar();
		calendar.setCalTitle(attendance.getHolidayType());
		calendar.setMemberId(attendance.getMemberId());
		calendar.setStartDate(formatter.format(attendance.getStartDate()));
		calendar.setEndDate(formatter.format(attendance.getEndDate()));
		if(result>0 && diff>=0) {
			calService.registerCal(calendar);
			mv.setViewName("redirect:attendanceList.do");
		}else {
			mv.setViewName("error");
		}
		return mv;
	}
	
	// 연차 삭제(취소)
	@RequestMapping(value="deleteAttendance.do")
	public String atdRemove(Model model, @RequestParam("attendanceNo") int attendanceNo) {
		int result = atdService.removeAttendance(attendanceNo);
		if(result>0) {
			return "redirect:attendanceList.do";
		}else {
			return "";
		}
	}
	
}
