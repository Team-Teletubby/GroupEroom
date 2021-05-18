package com.eroom.gw.notice.store;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.notice.domain.Notice;

public interface NoticeStore {
	
	public int selectListCount();
	public ArrayList<Notice> selectAllList(PageInfo pi); 
	public int addReadCount(int noticeNo);
	public Notice selectOne(int noticeNo);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int noticeNo);

}
