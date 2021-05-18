package com.eroom.gw.notice.service;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.notice.domain.Notice;

public interface NoticeService {

	public int getListCount();
	
	public ArrayList<Notice> printAll(PageInfo pi);
	
	
}
