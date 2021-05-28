package com.eroom.gw.notice.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;
import com.eroom.gw.notice.domain.Notice;
import com.eroom.gw.notice.service.NoticeService;
import com.eroom.gw.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeStore nStore;
	
	@Override
	public int getListCount() {
		return 0;
	}
	
	//전체목록
	@Override
	public ArrayList<Notice> printAll(PageInfo pi) {
		
		return nStore.selectAllList(pi);
	}

	@Override
	public int addReadCount(int noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Notice printOne(int noticeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerNotice(Notice notice) {
		return nStore.insertNotice(notice);
	}

	@Override
	public int modifyNotice(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
