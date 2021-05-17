package com.eroom.gw.cboard.service;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Cmt;
import com.eroom.gw.cboard.domain.PageInfo;

public interface CBoardService {
	
	public int getListCount();

	public ArrayList<CBoard> printAll(PageInfo pi);
	public int addReadCount(int cBoardNo);
	public CBoard printOne(int cBoardNo);
	public int registerBoard(CBoard cBoard);
	public int modifyBoard(CBoard cBoard);
	public int removeBoard(int cBoardNo);
	
	public ArrayList<Cmt> printAllCmt(int cBoardNo);
	public int registerCmt(Cmt cmt);
	public int modifyCmt(Cmt cmt);
	public int removeCmt(Cmt cmt);

}
