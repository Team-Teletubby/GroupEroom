package com.eroom.gw.mail.service;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailService {
	//메일함 리스트출력
	public ArrayList<Mail> printAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllSentMail(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllTrash(PageInfo pi, int receiverId);
	
	//페이징
	public int getListCount();
	public int addReadCount(int mailNo);

	//상세보기
	public Mail printOne(int mailNo);
	
	//메일쓰기
	public int composeMailSend(Mail mail);
	public int composeMailReceive(Mail mail);
	
	//파일
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize); //업로드

}
