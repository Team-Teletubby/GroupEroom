package com.eroom.gw.calendar.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.service.CalendarService;
import com.eroom.gw.calendar.store.CalendarStore;

@Service
public class CalendarServiceImpl implements CalendarService{

	@Autowired
	private CalendarStore calStore;
	
	@Override
	public ArrayList<Calendar> selelctAllCal(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar selectOneCal(int calNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCal(Calendar calendar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCal(Calendar calendar) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCal(int calNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
