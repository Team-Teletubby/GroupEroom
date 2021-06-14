package com.eroom.gw.mail.service.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	public int getInboxListCount() {
		return mStore.selectInboxListCount();
	}
	@Override
	public int getSentListCount() {
		return mStore.selectSentListCount();
	}
	@Override
	public int getTrashListCount() {
		return mStore.selectTrashListCount();
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
	public ArrayList<Mail> printAllInbox(int memberId) {
		return mStore.selectAllInbox(memberId);
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
//파일 
	@Override
	public Object fileUpload(String originalFilename, String renameFilename, String filePath, long fileSize) {
		HashMap<String, Object> hmap = new HashMap<>();
		hmap.put("originalFilename", originalFilename);
		hmap.put("renameFilename", renameFilename);
		hmap.put("filePath", filePath);
		hmap.put("fileSize", fileSize);
		
		return mStore.uploadFile(hmap);
	}
		
//메일이동 및 삭제
	@Override
	public int moveToTrash(Mail mail) {
		return mStore.updateTrashY(mail);
	}
	@Override
	public int returnToMailbox(Mail mail) {
		return mStore.updateTrashN(mail);
	}
	@Override
	public Object moveToTrashAjax(String mailNo) {
		return mStore.updateTrashAjax(mailNo);
	}
	@Override
	public int removeMail(Mail mail) {
		return mStore.deleteMail(mail);
	}
	



	
}
