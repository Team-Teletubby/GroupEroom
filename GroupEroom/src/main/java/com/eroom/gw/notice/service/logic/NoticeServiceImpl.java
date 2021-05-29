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
	
	//조회수
	@Override
	public int getListCount() {
		return nStore.selectListCount();
	}
	
	//전체목록
	@Override
	public ArrayList<Notice> printAll(PageInfo pi) {
		
		return nStore.selectAllList(pi);
	}

	//조회수증가
	@Override
	public int addReadCount(int noticeNo) {
		
		return nStore.addReadCount(noticeNo);
	}
	
	// 상세페이지
	@Override
	public Notice printOne(int noticeNo) {

		return nStore.selectOne(noticeNo);
	}
	// 등록
	@Override
	public int registerNotice(Notice notice) {
		return nStore.insertNotice(notice);
	}
	// 공지 수정 
	@Override
	public int modifyNotice(Notice notice) {
		return nStore.updateNotice(notice);
	}
	//공지삭제
	@Override
	public int removeNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
