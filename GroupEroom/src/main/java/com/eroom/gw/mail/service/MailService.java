package com.eroom.gw.mail.service;

import java.util.ArrayList;
import java.util.Map;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailService {
	//메일함 리스트출력
	public ArrayList<Mail> printAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllSentMail(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllTrash(PageInfo pi, int receiverId);

	//이동 및 삭제
	public int moveToTrash(Mail mail); //휴지통으로 이동
	public int returnToMailbox(Mail mail); //메일함으로 리턴
	
	//페이징
	public int getListCount();
	public int addReadCount(int mailNo);

	//상세보기
	public Mail printOne(int mailNo);
	
	//메일쓰기
	public int composeMailSend(Mail mail);
	public int composeMailReceive(Mail mail);
	
	//파일
	public Object fileUpload(String originalFilename, String renameFilename, String filePath, long fileSize); //업로드
	

}
