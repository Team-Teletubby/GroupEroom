package com.eroom.gw.cboard.store;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Cmt;
import com.eroom.gw.cboard.domain.PageInfo;

public interface CBoardStore {
	
	public int selectListCount();
	public ArrayList<CBoard> selectAllList(PageInfo pi);
	public int addReadCount(int cBoardNo);
	
	public CBoard selectOne(int cBoardNo);
	public int insertBoard(CBoard cBoard);
	public int updateBoard(CBoard cBoard);
	public int deleteBoard(int boardNo);
	
	public ArrayList<Cmt> selectAllCmt(int cBoardNo);
	public int insertCmt(Cmt cmt);
	public int updateCmt(Cmt cmt);
	public int deleteCmt(Cmt cmt);

}
