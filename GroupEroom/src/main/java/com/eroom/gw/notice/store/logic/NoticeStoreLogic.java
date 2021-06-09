package com.eroom.gw.notice.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;
import com.eroom.gw.notice.domain.Notice;
import com.eroom.gw.notice.store.NoticeStore;

@Repository
public class NoticeStoreLogic implements NoticeStore {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int selectListCount() {
		return sqlSession.selectOne("noticeMapper.selectListCount");
	}

	@Override
	public ArrayList<Notice> selectAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("noticeMapper.selectAllList", null, rowBounds); 
		
	}

	@Override
	public int addReadCount(int noticeNo) {
		
		return sqlSession.update("noticeMapper.updateCount", noticeNo);
	}

	@Override
	public Notice selectOne(int noticeNo) {
	
		return sqlSession.selectOne("noticeMapper.selectOne", noticeNo);
	}

	@Override
	public int insertNotice(Notice notice) {
		return sqlSession.insert("noticeMapper.insertNotice" , notice);
	}

	@Override
	public int updateNotice(Notice notice) {
	
		return sqlSession.update("noticeMapper.updateNotice", notice);
	}

	@Override
	public int deleteNotice(int noticeNo) {
		
		return sqlSession.delete("noticeMapper.deleteNotice", noticeNo);
		
	}

	@Override
	public ArrayList<Notice> selectSearchList(Search search, PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("noticeMapper.selectSearchList", search, rowBounds); 
	}

	@Override
	public int selectSearchListCount(Search search) {
		return sqlSession.selectOne("noticeMapper.selectSearchListCount", search);
	}

	@Override
	public ArrayList<Notice> selectAllList() {
		return (ArrayList)sqlSession.selectList("noticeMapper.selectList");
	}

	
}
