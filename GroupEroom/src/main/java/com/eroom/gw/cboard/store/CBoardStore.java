package com.eroom.gw.cboard.store;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;

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
	
	//검색짜증
	public ArrayList<CBoard> selectSearchList(Search search, PageInfo pi);
	public int selectSearchListCount(Search search);

}
