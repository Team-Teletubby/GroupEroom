package com.eroom.gw.mail.service.logic;

import java.util.ArrayList;

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
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Mail> printAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

}
