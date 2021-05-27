package com.eroom.gw.fboard.store.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
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
		return sqlSession.update("fBoardMapper.updateCount", fBoardNo);
	}

	@Override
	public Freeboard selectOne(int fBoardNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fBoardMapper.selectOne", fBoardNo);
	}

	@Override
	public int insertFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return sqlSession.insert("fBoardMapper.insertFBoard", fBoard);
	}

	@Override
	public int updateFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return sqlSession.update("fBoardMapper.updateFBoard", fBoard);
	}

	@Override
	public int deleteFBoard(int fBoardNo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("fBoardMapper.deleteFBoard", fBoardNo);
	}

//////////////////////////////////////////////// 댓글 ///////////////////////////////////////////////////
	
	@Override
	public ArrayList<FreeboardCmt> selectAllCmt(int fBoardNo) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("fBoardMapper.selectAllCmtList", fBoardNo);
	}

	@Override
	public int insertFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return sqlSession.insert("fBoardMapper.insertCmt", fBoardCmt);
	}

	@Override
	public int updateFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return sqlSession.update("fBoardMapper.updateCmt", fBoardCmt);
	}

	@Override
	public int deleteFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return sqlSession.delete("fBoardMapper.deleteCmt", fBoardCmt);
	}
	
//////////////////////////////////////////////// 파일 ///////////////////////////////////////////////////

	@Override
	public List<FreeboardFile> printFile(int fBoardNo) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("fBoardMapper.printFileList", fBoardNo);
	}
	
	@Override
	public Object uploadFile(HashMap<String, Object> hmap) {
		// TODO Auto-generated method stub
		return sqlSession.insert("fBoardMapper.uploadFile", hmap);
	}
	
//////////////////////////////////////////////// 검색 ///////////////////////////////////////////////////

	@Override
	public ArrayList<Freeboard> printFbSearchAll(Search search, PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("fBoardMapper.fbSelectSearchList", null, rowBounds); 
	}

	@Override
	public int searchFbListCount(Search search) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fBoardMapper.fbSearchListCount", search);
	}
	


}
