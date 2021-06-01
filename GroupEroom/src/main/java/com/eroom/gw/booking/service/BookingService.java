package com.eroom.gw.booking.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.eroom.gw.booking.domain.Booking;

public interface BookingService {
	
	public ArrayList<HashMap<Integer, String>> selectRoom();
	public int RegisterBooking(Booking booking);
	public ArrayList<String> bookingSelectDate(HashMap<String, Object> map);
	public ArrayList<Booking> selectAllBk();
	public int modifyBooking(Booking booking);
	int deleteBooking(int bookingNo);

}
