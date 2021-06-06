package com.eroom.gw.calendar.service;

import java.util.ArrayList;

import com.eroom.gw.calendar.domain.Calendar;

public interface CalendarService {
	
	public ArrayList<Calendar> selelctAllCal(int memberId);
	public int registerCal(Calendar calendar);
	public int modifyCal(Calendar calendar);
	public int removeCal(int calNo);
	public int updateDate(Calendar calendar);

}
