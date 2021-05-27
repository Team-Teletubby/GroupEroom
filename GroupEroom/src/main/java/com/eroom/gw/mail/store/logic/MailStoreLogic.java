package com.eroom.gw.mail.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.store.MailStore;

@Repository
public class MailStoreLogic implements MailStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int selectListCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mailMapper.selectListCount");
	}
	
	@Override
	public int addReadCount(int mailNo) {
		// TODO Auto-generated method stub
		return sqlSession.update("mailMapper.updateCount", mailNo);
	}
///////////////////////////////////////////리스트 조회////////////////////////////////////////////////
	@Override
	public ArrayList<Mail> selectAllInbox(PageInfo pi, int receiverId) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList) sqlSession.selectList("mailMapper.selectAllInbox", receiverId, rowBounds);
	}



}
