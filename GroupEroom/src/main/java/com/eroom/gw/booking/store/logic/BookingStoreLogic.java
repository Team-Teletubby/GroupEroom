package com.eroom.gw.booking.store.logic;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.booking.domain.Booking;
import com.eroom.gw.booking.store.BookingStore;

@Repository
public class BookingStoreLogic implements BookingStore {
	
	@Autowired
	private SqlSession session;

	@Override
	public ArrayList<HashMap<Integer, String>> selectRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> bookingSelectDate(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Booking> selectAllBooking(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return 0;
	}

}
