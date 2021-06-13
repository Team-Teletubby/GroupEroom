package com.eroom.gw.cboard.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.cboard.domain.Reply;
import com.eroom.gw.cboard.store.CBoardStore;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;

@Repository
public class CBoardStoreLogic implements CBoardStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectListCount() {
		return sqlSession.selectOne("cBoardMapper.selectListCount");
	}

	@Override
	public ArrayList<CBoard> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("cBoardMapper.selectAllList", null, rowBounds); 
	}

	@Override
	public int addReadCount(int cBoardNo) {
		return sqlSession.update("cBoardMapper.updateCount", cBoardNo);
	}

	@Override
	public CBoard selectOne(int cBoardNo) {
		return sqlSession.selectOne("cBoardMapper.selectOne", cBoardNo);
	}

	@Override
	public int insertBoard(CBoard cBoard) {
		return sqlSession.insert("cBoardMapper.insertcBoard",cBoard);
	}

	@Override
	public int updateBoard(CBoard cBoard) {
		return sqlSession.update("cBoardMapper.updatecBoard", cBoard);
	}

	@Override
	public int deleteBoard(int cBoardNo) {
		return sqlSession.delete("cBoardMapper.deletecBoard",cBoardNo);
	}

	@Override
	public ArrayList<CBoard> selectSearchList(Search search,PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("cBoardMapper.selectSearchList",search, rowBounds);
	}

	@Override
	public int selectSearchListCount(Search search) {
		return sqlSession.selectOne("cBoardMapper.selectSearchListCount",search);
	}

	@Override
	public ArrayList<Reply> selectAllReply(int cBoardNo) {
		return (ArrayList)sqlSession.selectList("cBoardMapper.selectReplyList", cBoardNo);
	}

	@Override
	public int insertReply(Reply reply) {
		return sqlSession.insert("cBoardMapper.insertReply", reply);
	}

	@Override
	public int updateReply(Reply reply) {
		return sqlSession.update("cBoardMapper.updateReply", reply);
	}

	@Override
	public int deleteReply(Reply reply) {
		return sqlSession.delete("cBoardMapper.deleteReply", reply);
	}

	@Override
	public int insertReplyChild(Reply reply) {
		System.out.println("로직컴");
		return sqlSession.insert("cBoardMapper.insertReplyChild", reply);
	}

	@Override
	public ArrayList<Reply> replyCount() {
		return (ArrayList)sqlSession.selectList("cBoardMapper.replyCount");
	}

	
}
