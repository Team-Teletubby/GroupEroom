package com.eroom.gw.cboard.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Cmt;
import com.eroom.gw.cboard.domain.PageInfo;
import com.eroom.gw.cboard.service.CBoardService;
import com.eroom.gw.cboard.store.CBoardStore;

@Service
public class CBoardServiceImpl implements CBoardService{
	
	@Autowired
	private CBoardStore store;

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CBoard> printAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addReadCount(int cBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CBoard printOne(int cBoardNo) {
		// TODO Auto-generated method stub
		return null;
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
	public ArrayList<Cmt> printAllCmt(int cBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCmt(Cmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCmt(Cmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCmt(Cmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
