package com.eroom.gw.attendance.store;

import java.util.ArrayList;

import com.eroom.gw.attendance.domain.Attendance;

public interface AttendanceStore {
	
	//신청한 연차 전체조회
		public ArrayList<Attendance> selectAllAttendance(int memberId);
		//연차 등록
		public int insertAttendance(Attendance attendance);
		//연차 취소
		public int deleteAttendance(int attendanceNo);
		public float usedHolidayCount(int memberId);

}
