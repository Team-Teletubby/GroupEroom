package com.eroom.gw.attendance.domain;

import com.eroom.gw.common.PageInfo;

public class Pagination {
	public static PageInfo getPageInfo(int currentPage, int listCount) {
		PageInfo pi = null;
		int pageLimit = 10; //한 페이지에서 보여줄 네비게이션의 수
		int maxPage; // 전체 페이지 중 가장 마지막 페이지
		int startPage; //현재 페이지에서 시작하는 첫번째 페이지
		int endPage; // 현재 페이지에서 끝나는 마지막 페이지
		int boardLimit = 5; //한 페이지에서 보여줄 게시글의 수
		
		maxPage = (int)((double)listCount/boardLimit + 0.9);
		startPage = (((int)((double)currentPage/pageLimit + 0.9))-1) * pageLimit + 1;
		endPage  = startPage + pageLimit -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		pi = new PageInfo(currentPage, boardLimit, pageLimit, startPage, endPage, listCount, maxPage);
		return pi;
	}
}
