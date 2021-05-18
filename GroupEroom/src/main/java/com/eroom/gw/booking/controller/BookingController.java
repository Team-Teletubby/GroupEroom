package com.eroom.gw.booking.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.booking.domain.Booking;
import com.eroom.gw.booking.service.BookingService;
import com.eroom.gw.member.service.MemberService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bService;
		
//예약리스트 조회화면
	@RequestMapping("bkListView.do")
	public ModelAndView bookingListView (ModelAndView mv, HttpSession session) {
		
		return mv;
	}
	
//예약생성 조회화면
	@RequestMapping("bkInsertView.do")
	public ModelAndView bookingInsertView(ModelAndView mv) {
		
		return mv;
	}
	
//예약생성
	@ResponseBody
	@RequestMapping("bkRegster.do")
	public ModelAndView bookingRegister(ModelAndView mv, HttpSession session, 
										@ModelAttribute Booking booking) {
		return mv;
	}

//날짜로부터 예약 내역 받아오기
	@RequestMapping("bkSelectDate.do")
	public void bookingSelectDate(HttpServletResponse response, 
								@RequestParam("date") String date, @RequestParam("roomNo") int roomNo) {
		
	}
	
//예약내용 수정
	@ResponseBody
	@RequestMapping("bkModify.do")
	public String bookingUpdate(@RequestParam("id") int id, @RequestParam("bStatus") String bStatus,
								@RequestParam("joinMember") String joinMember) {
		return "";
	}
}
