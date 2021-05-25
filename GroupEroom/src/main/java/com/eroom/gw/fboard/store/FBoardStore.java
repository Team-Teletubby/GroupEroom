package com.eroom.gw.fboard.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.common.Search;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;

public interface FBoardStore {
	
	public int selectListCount(); //게시물 전체 수
	public int addHits(int fBoardNo); //게시물 조회수 증가
	
	public ArrayList<Freeboard> selectAllList(PageInfo pi); //게시물 리스트조회
	public Freeboard selectOne(int fBoardNo); //게시물 상세조회
	public int insertFBoard(Freeboard fBoard); //게시물 작성
	public int updateFBoard(Freeboard fBoard); //게시물 수정
	public int deleteFBoard(int fBoardNo); //게시물 삭제
	
	public ArrayList<FreeboardCmt> selectAllCmt(int fBoardNo); //댓글조회
	public int insertFBoardCmt(FreeboardCmt fBoardCmt); //댓글생성
	public int updateFBoardCmt(FreeboardCmt fBoardCmt); //댓글수정
	public int deleteFBoardCmt(FreeboardCmt fBoardCmt); //댓글삭제
	
	public List<FreeboardFile> printFile(int fBoardNo); //파일리스트
	public Object uploadFile(HashMap<String, Object> hmap); //파일업로드
	public ArrayList<Freeboard> printSearchAll(Search search, PageInfo pi); //검색리스트
	public int searchListCount(Search search); //검색된 게시물 개수

}
