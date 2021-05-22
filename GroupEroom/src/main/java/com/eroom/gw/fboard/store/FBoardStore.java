package com.eroom.gw.fboard.store;

import java.util.ArrayList;
import java.util.HashMap;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;

public interface FBoardStore {
	
	public int selectListCount(); //게시물 전체 수
	public int addHits(int fBoardNo); //게시물 조회수 증가
	
	public ArrayList<Freeboard> selectAllList(PageInfo pi); //게시물 리스트조회
	public Freeboard selectOne(int fBoardNo); //게시물 상세조회
	public int insertFBoard(Freeboard fBoard); //게시물 작성
	public Object uploadFile(HashMap<String, Object> hmap); //파일업로드
	public int updateFBoard(Freeboard fBoard); //게시물 수정
	public int deleteFBoard(int fBoardNo); //게시물 삭제
	
	public ArrayList<FreeboardCmt> selectAllCmt(int fBoardNo); //댓글조회
	public int insertFBoardCmt(FreeboardCmt fBoardCmt); //댓글생성
	public int updateFBoardCmt(FreeboardCmt fBoardCmt); //댓글수정
	public int deleteFBoardCmt(FreeboardCmt fBoardCmt); //댓글삭제

}
