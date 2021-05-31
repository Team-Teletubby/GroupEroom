package com.eroom.gw.booking.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.booking.domain.Booking;
import com.eroom.gw.booking.service.BookingService;
import com.eroom.gw.member.domain.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

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
		// 로그인 세션 가져오기
		Member member = (Member)session.getAttribute("LoginUser");
		
		// RequestParam으로 가져온 값 객체에 넣어주기
		Booking booking = new Booking();
		booking.setMemberId(member.getMemberId());
		booking.setUsername(member.getMemberName());
		booking.setRoomNo(roomNo);
		booking.setTitle(bookingTitle);
		booking.setDescription(bContents);
		booking.setStart(bookingStartDate1);
		booking.setEnd(bookingEndDate1);

		// DB로 보내주기
		int result = bService.RegisterBooking(booking);
		
		if(result > 0 ) {
			return "success";	
		}else {
			return "error"; 
		}
	}

// 저장한 예약 가져오기
	@RequestMapping("bkSelectDate.do")
	public void bookingSelectDate(HttpServletResponse response) throws JsonIOException, IOException {
		ArrayList<Booking> bList = bService.selectAllBk();
		
		if(!bList.isEmpty()) {

			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(bList, response.getWriter());
		}else {
			System.out.println("오류");
		}
	}
	
//예약내용 수정
	@ResponseBody
	@RequestMapping("bkModify.do")
	public String bookingUpdate(@RequestParam("id") int id, @RequestParam("bStatus") String bStatus,
								@RequestParam("joinMember") String joinMember) {
		return "";
	}
}
