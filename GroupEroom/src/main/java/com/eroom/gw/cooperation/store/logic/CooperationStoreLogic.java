package com.eroom.gw.cooperation.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.store.CooperationStore;

@Repository
public class CooperationStoreLogic implements CooperationStore {
	
	@Autowired
	private SqlSession session;

	@Override
	public ArrayList<Cooperation> selectAllList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCooperation(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCooperation(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCooperation(int coNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CooperationCmt> selectAllCmt(int coNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCooperationCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCooperationCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCooperationCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
