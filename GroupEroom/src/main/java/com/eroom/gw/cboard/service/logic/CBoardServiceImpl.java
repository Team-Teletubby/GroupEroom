package com.eroom.gw.cboard.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.cboard.service.CBoardService;
import com.eroom.gw.cboard.store.CBoardStore;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;

@Service
public class CBoardServiceImpl implements CBoardService{
	
	@Autowired
	private CBoardStore store;

	@Override
	public int getListCount() {
		return store.selectListCount();
	}

	@Override
	public ArrayList<CBoard> printAll(PageInfo pi) {
		return store.selectAllList(pi);
	}

	@Override
	public int addReadCount(int cBoardNo) {
		return store.addReadCount(cBoardNo);
	}

	@Override
	public CBoard printOne(int cBoardNo) {
		return store.selectOne(cBoardNo);
	}

	@Override
	public int registerBoard(CBoard cBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyBoard(CBoard cBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(int cBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CBoardCmt> printAllCmt(int cBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCmt(CBoardCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	//검색
	@Override
	public ArrayList<CBoard> printSearchAll(Search search,PageInfo pi) {
		return store.selectSearchList(search, pi);
	}

	@Override
	public int getSearchListCount(Search search) {
		return store.selectSearchListCount(search);
	}

	

}
