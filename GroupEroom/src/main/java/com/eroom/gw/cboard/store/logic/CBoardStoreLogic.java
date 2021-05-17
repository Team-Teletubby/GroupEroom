package com.eroom.gw.cboard.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.cboard.domain.PageInfo;
import com.eroom.gw.cboard.store.CBoardStore;

@Repository
public class CBoardStoreLogic implements CBoardStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CBoard> selectAllList(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
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
