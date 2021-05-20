package com.eroom.gw.cboard.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.cboard.store.CBoardStore;
import com.eroom.gw.common.PageInfo;

@Repository
public class CBoardStoreLogic implements CBoardStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectListCount() {
		return sqlSession.selectOne("cBoardMapper.selectListCount");
	}

	@Override
	public ArrayList<CBoard> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("cBoardMapper.selectAllList", null, rowBounds); 
	}

	@Override
	public int addReadCount(int cBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CBoard selectOne(int cBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(CBoard cBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(CBoard cBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CBoardCmt> selectAllCmt(int cBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}



}
