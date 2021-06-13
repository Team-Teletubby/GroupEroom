package com.eroom.gw.cboard.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Reply;
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
		return store.insertBoard(cBoard);
	}

	@Override
	public int modifyBoard(CBoard cBoard) {
		return store.updateBoard(cBoard);
	}

	@Override
	public int removeBoard(int cBoardNo) {
		return store.deleteBoard(cBoardNo);
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

	
	//댓글쓰,,
	@Override
	public ArrayList<Reply> printAllReply(int cBoardNo) {
		return store.selectAllReply(cBoardNo);
	}

	@Override
	public int registerReply(Reply reply) {
		return store.insertReply(reply);
	}

	@Override
	public int modifyReply(Reply reply) {
		return store.updateReply(reply);
	}

	@Override
	public int removeReply(Reply reply) {
		return store.deleteReply(reply);
	}

	@Override
	public int registerReplyChild(Reply reply) {
		return store.insertReplyChild(reply);
	}

	@Override
	public ArrayList<Reply> replyCount() {
		return store.replyCount();
	}

	

}
