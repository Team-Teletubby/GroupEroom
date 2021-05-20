package com.eroom.gw.mail.store;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;

public interface MailStore {
	
	public int selectListCount();
	public ArrayList<Mail> selectAllList(PageInfo pi);

}
