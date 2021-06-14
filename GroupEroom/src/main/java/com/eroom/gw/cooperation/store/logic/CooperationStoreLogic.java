package com.eroom.gw.cooperation.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;
import com.eroom.gw.cooperation.store.CooperationStore;

@Repository
public class CooperationStoreLogic implements CooperationStore {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<CooperationRoom> selectAllList() {
		return (ArrayList)sqlSession.selectList("coopMapper.selectAllList");
	}
	
	@Override
	public int insertRoom(CooperationRoom room) {
		return sqlSession.insert("coopMapper.insertRoom", room);
	}

	@Override
	public ArrayList<Cooperation> selectAllByRoom(int roomNo) {
		return (ArrayList)sqlSession.selectList("coopMapper.selectAllByRoom", roomNo);
	}

	@Override
	public int insertCoop(Cooperation coop) {
		return sqlSession.insert("coopMapper.insertCoop", coop);
	}

	@Override
	public int updateCoop(Cooperation coop) {
		return 0;
	}

	@Override
	public int deleteCoop(int coNo) {
		return sqlSession.delete("coopMapper.deleteCoop", coNo);
	}

	@Override
	public ArrayList<CooperationCmt> selectAllCmt(int coNo) {
		return (ArrayList)sqlSession.selectList("coopMapper.selectAllCmt", coNo);
	}

	@Override
	public int insertCoopCmt(CooperationCmt cmt) {
		return sqlSession.insert("coopMapper.insertCmt", cmt);
	}

	@Override
	public int updateCoopCmt(CooperationCmt cmt) {
		return sqlSession.update("coopMapper.updateCmt", cmt);
	}

	@Override
	public int deleteCoopCmt(CooperationCmt cmt) {
		return sqlSession.delete("coopMapper.deleteCmt", cmt);
	}

	@Override
	public CooperationCmt selectOne(int coNo) {
		return sqlSession.selectOne("coopMapper.selectOne", coNo);
	}

	
}
