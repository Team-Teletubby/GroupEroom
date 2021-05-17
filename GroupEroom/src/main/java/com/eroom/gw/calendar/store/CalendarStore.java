package com.eroom.gw.calendar.store;

import java.util.ArrayList;

import com.eroom.gw.calendar.domain.Calendar;

public interface CalendarStore {
	
	public ArrayList<Calendar> selectAllCal(String memberId);
	public Calendar selectOneCal(Calendar calendar);
	public int insertCal(Calendar calendar);
	public int updateCal(Calendar calendar);
	public int deleteCal(int calNo);

}
