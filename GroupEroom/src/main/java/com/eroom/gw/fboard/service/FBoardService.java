package com.eroom.gw.fboard.service;

import java.util.ArrayList;
import java.util.List;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;

public interface FBoardService {
	
	public int getListCount(); //게시물 전체 개수
	public int addHits(int fBoardNo); //게시물 조회수 증가
	
	public ArrayList<Freeboard> printAll(PageInfo pi); //게시물 리스트조회
	public Freeboard printOne(int fBoardNo); //게시물 상세조회
	public int registerFBoard(Freeboard fBoard); //게시물 작성
	public int modifyFBoard(Freeboard fBoard); //게시물 수정
	public int removeFBoard(int fBoardNo); //게시물 삭제
	
	public ArrayList<FreeboardCmt> printAllCmt(int fBoardNo); //댓글조회
	public int registerFBoardCmt(FreeboardCmt fBoardCmt); //댓글생성
	public int modifyFBoardCmt(FreeboardCmt fBoardCmt); //댓글수정
	public int removeFBoardCmt(FreeboardCmt fBoardCmt); //댓글삭제
	
	public List<FreeboardFile> printFile(int fBoardNo); //파일 리스트 출력	
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize); //파일업로드
	public ArrayList<Freeboard> printSearchAll(Search search, PageInfo pi); //검색
	public int getSearchListCount(Search search); //검색 전체 개수
	

}
