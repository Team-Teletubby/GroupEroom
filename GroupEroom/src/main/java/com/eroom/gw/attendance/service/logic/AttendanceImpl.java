package com.eroom.gw.attendance.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.attendance.service.AttendanceService;
import com.eroom.gw.attendance.store.AttendanceStore;

@Service
public class AttendanceImpl implements AttendanceService{

	@Autowired
	private AttendanceStore atdStore;
	
	@Override
	public ArrayList<Attendance> selectAllAttendance(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerAttendance(Attendance attendance) {
		return atdStore.insertAttendance(attendance);
	}

	@Override
	public int removeAttendance(int attendanceNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
