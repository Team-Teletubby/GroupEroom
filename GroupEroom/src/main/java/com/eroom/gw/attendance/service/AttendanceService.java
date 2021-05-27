package com.eroom.gw.attendance.service;

import java.util.ArrayList;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.common.PageInfo;

public interface AttendanceService {
	
	//신청한 연차 전체조회
	public ArrayList<Attendance> selectAllAttendance(PageInfo pi, int memberId);
	//연차 등록
	public int registerAttendance(Attendance attendance);
	//연차 취소
	public int removeAttendance(int attendanceNo);
	public float usedHolidayCount(int memberId);
	public int getListCount(int memberId);
}
