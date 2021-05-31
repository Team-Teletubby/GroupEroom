package com.eroom.gw.booking.service.logic;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.booking.domain.Booking;
import com.eroom.gw.booking.service.BookingService;
import com.eroom.gw.booking.store.BookingStore;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingStore bStore;

	@Override
	public ArrayList<HashMap<Integer, String>> selectRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	// 예약 등록
	@Override
	public int RegisterBooking(Booking booking) {
		return bStore.insertBooking(booking);
	}

	@Override
	public ArrayList<String> bookingSelectDate(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Booking> selectAllBk(int MemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modifyBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

}
