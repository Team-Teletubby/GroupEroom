package com.eroom.gw.calendar.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.calendar.domain.Calendar;
import com.eroom.gw.calendar.store.CalendarStore;

@Repository
public class CalendarStoreLogic implements CalendarStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Calendar> selectAllCal(int memberId) {
		return (ArrayList)sqlSession.selectList("calMapper.selectAllCal",memberId);
	}

	@Override
	public int insertCal(Calendar calendar) {
		return sqlSession.insert("calMapper.insertCal", calendar);
	}

	@Override
	public int updateCal(Calendar calendar) {
		return sqlSession.update("calMapper.updateCal", calendar);
	}

	@Override
	public int deleteCal(int calNo) {
		return sqlSession.delete("calMapper.deleteCal", calNo);
	}

}
