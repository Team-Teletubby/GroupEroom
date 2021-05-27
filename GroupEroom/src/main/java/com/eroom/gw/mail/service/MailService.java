package com.eroom.gw.mail.service;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailService {
	//메일함 리스트출력
	public ArrayList<Mail> printAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllSentMail(PageInfo pi);
	public ArrayList<Mail> printAllTrash(PageInfo pi);
	
	//페이징
	public int getListCount();
	public int addReadCount(int mailNo);

	//상세보기
	public Mail selectOneInbox(int mailNo);
	public Mail selectOneSentMail(int mailNo);
	public Mail selectOneTrash(int mailNo);
	
	//메일쓰기&지우기&옮기기
	public int ComposeMail(Mail mail); //메일쓰기
	public int moveTrash(int mailNo); //휴지통으로
	public int deleteMail(int mailNo); //휴지통비우기
	
	//파일
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize); //업로드

}
