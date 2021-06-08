package com.eroom.gw.mail.store;

import java.util.ArrayList;
import java.util.Map;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailStore {
	
	public int selectListCount();
	public int addReadCount(int mailNo);
	public ArrayList<Mail> selectAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> selectAllSentMail(PageInfo pi, int senderId);
	public ArrayList<Mail> selectAllTrash(PageInfo pi, int receiverId);
	public Mail selectOneMail(int mailNo);
	public int composeMailSender(Mail mail);
	public int composeMailReceiver(Mail mail);
	public int updateTrashY(Mail mail);
	public int updateTrashN(Mail mail);

}
