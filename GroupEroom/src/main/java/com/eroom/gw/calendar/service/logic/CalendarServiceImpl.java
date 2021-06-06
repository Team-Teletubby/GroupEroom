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
	public ArrayList<Calendar> selelctAllCal(int memberId) {
		return calStore.selectAllCal(memberId);
	}

	@Override
	public int registerCal(Calendar calendar) {
		return calStore.insertCal(calendar);
	}

	@Override
	public int modifyCal(Calendar calendar) {
		return calStore.updateCal(calendar);
	}

	@Override
	public int removeCal(int calNo) {
		return calStore.deleteCal(calNo);
	}

	@Override
	public int updateDate(Calendar calendar) {
		return calStore.updateDate(calendar);
	}

}
