package com.eroom.gw.mail.service;

import java.util.ArrayList;
import java.util.Map;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailService {
	//메일함 리스트출력
	public ArrayList<Mail> printAllInbox(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllInbox(int memberId); // 추가함 (메인에 출력하기 위해서)
	public ArrayList<Mail> printAllSentMail(PageInfo pi, int receiverId);
	public ArrayList<Mail> printAllTrash(PageInfo pi, int receiverId);

	//이동 및 삭제
	public int moveToTrash(Mail mail); //휴지통으로 이동
	public Object moveToTrashAjax(String mailNo); //선택하여 이동
	public int returnToMailbox(Mail mail); //메일함으로 리턴
	public int removeMail(Mail mail); //영구삭제
	
	//페이징
	public int getInboxListCount(); //받은메일함
	public int getSentListCount(); //보낸메일함
	public int getTrashListCount(); //휴지통
	public int addReadCount(int mailNo); //읽음확인

	//상세보기
	public Mail printOne(int mailNo);
	
	//메일쓰기
	public int composeMailSend(Mail mail);
	public int composeMailReceive(Mail mail);
	
	//파일
	public Object fileUpload(String originalFilename, String renameFilename, String filePath, long fileSize); //업로드
	

}
