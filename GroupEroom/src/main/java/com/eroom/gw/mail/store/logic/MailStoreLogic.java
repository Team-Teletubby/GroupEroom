package com.eroom.gw.mail.store.logic;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.mail.domain.Mail;
import com.eroom.gw.mail.store.MailStore;

@Repository
public class MailStoreLogic implements MailStore {

	@Override
	public int selectListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Mail> selectAllList(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

}
