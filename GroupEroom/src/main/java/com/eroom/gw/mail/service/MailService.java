package com.eroom.gw.mail.service;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailService {
	
	public int getListCount();
	public ArrayList<Mail> printAll(PageInfo pi);
	

}
