package com.eroom.gw.mail.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailStore {
	
	public int selectInboxListCount();
	public int selectSentListCount();
	public int selectTrashListCount();
	public int addReadCount(int mailNo);
	public ArrayList<Mail> selectAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> selectAllInbox(int memberId);
	public ArrayList<Mail> selectAllSentMail(PageInfo pi, int senderId);
	public ArrayList<Mail> selectAllTrash(PageInfo pi, int receiverId);
	public Mail selectOneMail(int mailNo);
	public int composeMailSender(Mail mail);
	public Object uploadFile(HashMap<String, Object> hmap);
	public int composeMailReceiver(Mail mail);
	public int updateTrashY(Mail mail);
	public int updateTrashN(Mail mail);
	public int deleteMail(Mail mail);
	public Object updateTrashAjax(String mailNo);

}
