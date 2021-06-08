package com.eroom.gw.mail.store.logic;

import java.util.ArrayList;
import java.util.Map;

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
	

//받은편지함리스트
	@Override
	public ArrayList<Mail> selectAllInbox(PageInfo pi, int receiverId) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList) sqlSession.selectList("mailMapper.selectAllInbox", receiverId, rowBounds);
	}
	
//보낸편지함리스트
	@Override
	public ArrayList<Mail> selectAllSentMail(PageInfo pi, int senderId) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList) sqlSession.selectList("mailMapper.selectAllSentMail", senderId, rowBounds);
	}
	
//휴지통리스트
	@Override
	public ArrayList<Mail> selectAllTrash(PageInfo pi, int receiverId) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList) sqlSession.selectList("mailMapper.selectAllTrash", receiverId, rowBounds);
	}

//메일보기
	@Override
	public Mail selectOneMail(int mailNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mailMapper.selectOneMail", mailNo);
	}
	
//메일보내기
	@Override
	public int composeMailSender(Mail mail) { //보낸메일함에 띄울 메일
		return sqlSession.insert("mailMapper.composeMailSend", mail);
	}
	@Override
	public int composeMailReceiver(Mail mail) { //받은편지함에 띄울 메일
		return sqlSession.insert("mailMapper.composeMailReceive", mail);
	}

//메일함=>휴지통 이동
	@Override
	public int updateTrashY(Mail mail) {
		return sqlSession.update("mailMapper.updateTrashY", mail);
	}

//휴지통=>메일함 이동
	@Override
	public int updateTrashN(Mail mail) {
		return sqlSession.update("mailMapper.updateTrashN", mail);
	}

}
