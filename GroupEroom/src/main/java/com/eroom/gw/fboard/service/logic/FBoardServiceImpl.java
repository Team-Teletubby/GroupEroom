package com.eroom.gw.fboard.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.service.FBoardService;
import com.eroom.gw.fboard.store.FBoardStore;

@Service
public class FBoardServiceImpl implements FBoardService{

	@Autowired
	private FBoardStore fStore;
	
	@Override
	public int getListHits() {
		// TODO Auto-generated method stub
		return fStore.selectListHits();
	}

	@Override
	public int addHits(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Freeboard> printAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return fStore.selectAllList(pi);
	}

	@Override
	public Freeboard printOne(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFBoard(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<FreeboardCmt> printAllCmt(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
