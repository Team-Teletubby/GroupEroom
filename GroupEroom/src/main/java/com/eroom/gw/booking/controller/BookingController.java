package com.eroom.gw.booking.controller;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.booking.domain.Booking;
import com.eroom.gw.booking.service.BookingService;
import com.eroom.gw.member.domain.Member;
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
	
//예약생성 화면
	@RequestMapping("bkRegisterView.do")
	public String bkRegisterView() {
		
		return "booking/roomReservation";
	}
	
//예약생성
	@ResponseBody
	@RequestMapping(value="bkRegister.do", method=RequestMethod.POST)
	public String bookingRegister(HttpSession session, 
										@RequestParam(value="roomNo")int roomNo,
										@RequestParam(value="bookingTitle")String bookingTitle,
										@RequestParam(value="bContents")String bContents,
										@RequestParam(value="bookingStartDate")String bookingStartDate1,
										@RequestParam(value="bookingEndDate")String bookingEndDate1
										) throws ParseException {
//		System.out.println(roomNo);
//		System.out.println(bookingTitle);
//		System.out.println(bContents);
//		System.out.println(bookingStartDate);
//		System.out.println(bookingEndDate);
		
		// 로그인 세션 가져오기
		Member member = (Member)session.getAttribute("LoginUser");
		
		// RequestParam으로 가져온 값 객체에 넣어주기
		Booking booking = new Booking();
		booking.setRoomNo(roomNo);
		booking.setBookingTitle(bookingTitle);
		booking.setbContents(bContents);
		// String으로 받아온 날짜값 Date로 형변환
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH");
		Date bookingStartDate = (Date) fm.parse(bookingStartDate1);
		booking.setBookingStartDate(bookingStartDate);
		Date bookingEndDate = (Date) fm.parse(bookingEndDate1);
		booking.setBookingEndDate(bookingEndDate);
		
		// DB로 보내주기
		int result = bService.RegisterBooking(booking);
		return "success";
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
