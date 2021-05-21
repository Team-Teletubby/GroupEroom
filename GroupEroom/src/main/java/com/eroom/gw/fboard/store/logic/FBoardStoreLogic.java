package com.eroom.gw.fboard.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.cboard.domain.CBoard;
import com.eroom.gw.common.PageInfo;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.store.FBoardStore;

@Repository
public class FBoardStoreLogic implements FBoardStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int selectListCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fBoardMapper.selectListCount");
	}

	@Override
	public ArrayList<Freeboard> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("fBoardMapper.selectAllList", null, rowBounds); 
	}
	
	@Override
	public int addHits(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Freeboard selectOne(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFBoard(int fBoardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<FreeboardCmt> selectAllCmt(int fBoardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
