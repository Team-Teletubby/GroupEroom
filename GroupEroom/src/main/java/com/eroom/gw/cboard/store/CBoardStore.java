package com.eroom.gw.cboard.store;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.common.PageInfo;

public interface CBoardStore {
	
	public int selectListCount();
	public ArrayList<CBoard> selectAllList(PageInfo pi);
	public int addReadCount(int cBoardNo);
	
	public CBoard selectOne(int cBoardNo);
	public int insertBoard(CBoard cBoard);
	public int updateBoard(CBoard cBoard);
	public int deleteBoard(int boardNo);
	
	public ArrayList<CBoardCmt> selectAllCmt(int cBoardNo);
	public int insertCmt(CBoardCmt cmt);
	public int updateCmt(CBoardCmt cmt);
	public int deleteCmt(CBoardCmt cmt);

}
