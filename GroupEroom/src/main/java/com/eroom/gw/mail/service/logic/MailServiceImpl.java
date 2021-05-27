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
	public ArrayList<Mail> printAllSentMail(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Mail> printAllTrash(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail selectOneInbox(int mailNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail selectOneSentMail(int mailNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mail selectOneTrash(int mailNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ComposeMail(Mail mail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int moveTrash(int mailNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMail(int mailNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
