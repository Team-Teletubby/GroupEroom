package com.eroom.gw.cboard.service;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.CBoardCmt;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;

public interface CBoardService {
	
	public int getListCount();

	public ArrayList<CBoard> printAll(PageInfo pi);
	public int addReadCount(int cBoardNo);
	public CBoard printOne(int cBoardNo);
	public int registerBoard(CBoard cBoard);
	public int modifyBoard(CBoard cBoard);
	public int removeBoard(int cBoardNo);
	
	public ArrayList<CBoardCmt> printAllCmt(int cBoardNo);
	public int registerCmt(CBoardCmt cmt);
	public int modifyCmt(CBoardCmt cmt);
	public int removeCmt(CBoardCmt cmt);

	
	//검색시벌..
	public ArrayList<CBoard> printSearchAll(Search search, PageInfo pi);
	public int getSearchListCount(Search search);

}
