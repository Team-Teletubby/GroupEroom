package com.eroom.gw.mail.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.service.MailService;
import com.eroom.gw.mail.store.MailStore;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private MailStore mStore;
	
	@Override
	public int getListCount() {
		return mStore.selectListCount();
	}
	
	@Override
	public int addReadCount(int mailNo) {
		return mStore.addReadCount(mailNo);
	}

	@Override
	public ArrayList<Mail> printAllInbox(PageInfo pi, int receiverId) {
		return mStore.selectAllInbox(pi, receiverId);
	}

	@Override
	public ArrayList<Mail> printAllSentMail(PageInfo pi, int senderId) {
		return mStore.selectAllSentMail(pi, senderId);
	}

	@Override
	public ArrayList<Mail> printAllTrash(PageInfo pi, int receiverId) {
		// TODO Auto-generated method stub
		return mStore.selectAllTrash(pi, receiverId);
	}

	@Override
	public Mail printOne(int mailNo) {
		// TODO Auto-generated method stub
		return mStore.selectOneMail(mailNo);
	}
	
//메일쓰기
	@Override
	public int composeMailSend(Mail mail) {
		return mStore.composeMailSender(mail);
	}
	@Override
	public int composeMailReceive(Mail mail) {
		return mStore.composeMailReceiver(mail);
	}

	
	
	
	
	
	@Override
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
