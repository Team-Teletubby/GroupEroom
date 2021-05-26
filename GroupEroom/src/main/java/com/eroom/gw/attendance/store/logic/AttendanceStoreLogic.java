package com.eroom.gw.attendance.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.attendance.store.AttendanceStore;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Attendance> selectAllAttendance(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertAttendance(Attendance attendance) {
		return sqlSession.insert("attendanceMapper.insertAttendance",attendance);
	}

	@Override
	public int deleteAttendance(int attendanceNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float usedHolidayCount(int memberId) {
		return sqlSession.selectOne("attendanceMapper.usedHolidayCount", memberId);
	}

}
