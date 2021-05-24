package com.eroom.gw.cboard.store;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Reply;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;

public interface CBoardStore {
	
	public int selectListCount();
	public ArrayList<CBoard> selectAllList(PageInfo pi);
	public int addReadCount(int cBoardNo);
	
	public CBoard selectOne(int cBoardNo);
	public int insertBoard(CBoard cBoard);
	public int updateBoard(CBoard cBoard);
	public int deleteBoard(int cBoardNo);
	
	public ArrayList<Reply> selectAllReply(int cBoardNo);
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(Reply reply);
	
	public ArrayList<CBoard> selectSearchList(Search search, PageInfo pi);
	public int selectSearchListCount(Search search);

}
