package com.eroom.gw.mail.service;

import java.util.List;
import java.util.Map;

import com.eroom.gw.mail.domain.Mail;

public interface MailService {

	public void regist(Mail mail) throws Exception;
	
	public void regist2(Mail mail) throws Exception;
	
	public Mail read(Map param) throws Exception;
	
	public void modify(Map param) throws Exception;
	 
	public void remove(Map param) throws Exception; 
	
	public List<Mail> sndListAll(Mail mail) throws Exception;
	
	public List<Mail> rcvListAll(Mail mail) throws Exception;
	
	public void rcvCount(int mailNo) throws Exception;
	
	public void sndCount(int mailNo) throws Exception;
	
	public int rcvSearchCount(Mail mail) throws Exception;
	
	public int sndSearchCount(Mail mail) throws Exception;
	
	
	
}
