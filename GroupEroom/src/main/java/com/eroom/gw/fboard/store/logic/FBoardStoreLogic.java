package com.eroom.gw.fboard.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.store.FBoardStore;

@Repository
public class FBoardStoreLogic implements FBoardStore {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int selectListHits() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fBoardMapper.selectListHits");
	}

	@Override
	public int addHits(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Freeboard> selectAllList(PageInfo pi) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("fBoardMapper.selectAllList", pi);
	}

	@Override
	public Freeboard selectOne(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFBoard(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<FreeboardCmt> selectAllCmt(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
