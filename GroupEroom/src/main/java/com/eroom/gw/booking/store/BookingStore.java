package com.eroom.gw.booking.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.eroom.gw.booking.domain.Booking;

public interface BookingStore {
	
	public ArrayList<HashMap<Integer, String>> selectRoom();
	public int insertBooking(Booking booking);
	public ArrayList<String> bookingSelectDate(HashMap<String, Object> map);
	public ArrayList<Booking> selectAllBooking();
	public int updateBooking(Booking booking);
	public int deleteBooking(int bookingNo);

}
