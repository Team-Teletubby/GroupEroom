package com.eroom.gw.attendance.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.attendance.domain.Attendance;
import com.eroom.gw.attendance.store.AttendanceStore;
import com.eroom.gw.common.PageInfo;

@Repository
public class AttendanceStoreLogic implements AttendanceStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Attendance> selectAllAttendance(PageInfo pi,int memberId) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("attendanceMapper.selectAllList",memberId, rowBounds);
	}

	@Override
	public int insertAttendance(Attendance attendance) {
		return sqlSession.insert("attendanceMapper.insertAttendance",attendance);
	}

	@Override
	public int deleteAttendance(int attendanceNo) {
		return sqlSession.delete("attendanceMapper.deleteAttendance",attendanceNo);
	}

	@Override
	public float usedHolidayCount(int memberId) {
		return sqlSession.selectOne("attendanceMapper.usedHolidayCount", memberId);
	}

	@Override
	public int getListCount(int memberId) {
		return sqlSession.selectOne("attendanceMapper.listCount", memberId);
	}

	@Override
	public int updateDone() {
		return sqlSession.update("attendanceMapper.updateDone");
	}

}
