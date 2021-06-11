package com.eroom.gw.workStatus.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eroom.gw.workStatus.domain.WorkStatus;
import com.eroom.gw.workStatus.store.WorkStatusStore;

@Component
public class WorkStatusStoreLogic implements WorkStatusStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 집무 현황 등록
	 */
	@Override
	public int insertWorkMember(WorkStatus workStatus) {
		return sqlSession.insert("workStatusMapper.insertWorkMember", workStatus);
	}

}
