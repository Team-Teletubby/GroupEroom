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
	public String bookingListView() {
		
		return "booking/bookingView";
	}

//예약생성 화면
	@RequestMapping("bkRegisterView.do")
	public String bkRegisterView() {

		return "booking/roomReservation";
	}

//예약생성
	@ResponseBody
	@RequestMapping(value = "bkRegister.do", method = RequestMethod.POST)
	public String bookingRegister(HttpSession session, @RequestParam(value = "roomNo") int roomNo,
			@RequestParam(value = "bookingTitle") String bookingTitle,
			@RequestParam(value = "bContents") String bContents,
			@RequestParam(value = "bookingStartDate") String bookingStartDate1,
			@RequestParam(value = "bookingEndDate") String bookingEndDate1) throws ParseException {
		// 로그인 세션 가져오기
		Member member = (Member) session.getAttribute("LoginUser");

		// RequestParam으로 가져온 값 객체에 넣어주기
		Booking booking = new Booking();
		booking.setMemberId(member.getMemberId());
		booking.setUsername(member.getMemberName());
		booking.setUserDept(member.getMemberDept());
		booking.setRoomNo(roomNo);
		booking.setTitle(bookingTitle);
		booking.setDescription(bContents);
		booking.setStart(bookingStartDate1);
		booking.setEnd(bookingEndDate1);
		
		// 현재 시간과 예약한 시간 비교
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
		Date toDay = format.parse(format.format(new Date()));
		Date start = format.parse(booking.getStart());
		
		// 1 : 예약한 날이 현재보다 더 과거 
		// 0 : 현재 시간과 동일 
		// -1 : 예약한 날이 미래
		int compare = toDay.compareTo(start);
		String result = "";
		
		// 예약한 날짜가 미래일 경우
		if(compare == -1) {
			ArrayList<Booking> bList = bService.selectAllBk();
			for(int i = 0; i < bList.size(); i++) {
				// DB에 저장된 시작 시간과 지금 예약한 시작 시간이 같을 경우
				if(booking.getStart().equals(bList.get(i).getStart())) {
					// DB에 저장된 회의실번호와 지금 예약한 회의실 번호가 같을 경우
					if(booking.getRoomNo() == bList.get(i).getRoomNo()) {
						result = "bookingError";
						
					}
				}
			}
			
			if(!result.equals("bookingError")) {
				int bookingRegister = bService.RegisterBooking(booking);
				
				if(bookingRegister > 0) {
					result = "success";
				}
			}
			
		}else if(compare == 1) {
			result = "dayError";
		}
		return result;
	}

// 저장한 예약 가져오기
	@RequestMapping("bkSelectDate.do")
	public void bookingSelectDate(HttpServletResponse response) throws JsonIOException, IOException {
		ArrayList<Booking> bList = bService.selectAllBk();

		if (!bList.isEmpty()) {

			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(bList, response.getWriter());
		} else {
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
	
// 예약 삭제
	@RequestMapping("bkDelete.do")
	public String bookingDelete(@RequestParam("bookingNo")String no) {
		System.out.println("삭제 들어옴");
		System.out.println(no);
		
		int bookingNo = Integer.parseInt(no);
		int result = bService.deleteBooking(bookingNo);
		String resultStr = "";
		
		if(result > 0) {
			resultStr = "success";
		}else {
			resultStr = "error";
		}
		return resultStr;
	}
}
