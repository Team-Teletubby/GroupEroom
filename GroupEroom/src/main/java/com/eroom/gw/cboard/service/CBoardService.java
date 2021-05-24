package com.eroom.gw.cboard.service;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Reply;
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
	
	public ArrayList<Reply> printAllReply(int cBoardNo);
	public int registerReply(Reply reply);
	public int modifyReply(Reply reply);
	public int removeReply(Reply reply);

	
	//검색
	public ArrayList<CBoard> printSearchAll(Search search, PageInfo pi);
	public int getSearchListCount(Search search);

}
