package com.eroom.gw.attendance.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.attendance.service.AttendanceService;
import com.eroom.gw.attendance.store.AttendanceStore;
import com.eroom.gw.common.PageInfo;

@Service
public class AttendanceImpl implements AttendanceService{

	@Autowired
	private AttendanceStore atdStore;
	
	@Override
	public ArrayList<Attendance> selectAllAttendance(PageInfo pi,int memberId) {
		return atdStore.selectAllAttendance(pi,memberId);
	}

	@Override
	public int registerAttendance(Attendance attendance) {
		return atdStore.insertAttendance(attendance);
	}

	@Override
	public int removeAttendance(int attendanceNo) {
		return atdStore.deleteAttendance(attendanceNo);
	}

	@Override
	public float usedHolidayCount(int memberId) {
		return atdStore.usedHolidayCount(memberId);
	}

	@Override
	public int getListCount(int memberId) {
		return atdStore.getListCount(memberId);
	}

}
