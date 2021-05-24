package com.eroom.gw.fboard.service.logic;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.fboard.domain.Freeboard;
import com.eroom.gw.fboard.domain.FreeboardCmt;
import com.eroom.gw.fboard.domain.FreeboardFile;
import com.eroom.gw.fboard.service.FBoardService;
import com.eroom.gw.fboard.store.FBoardStore;

@Service
public class FBoardServiceImpl implements FBoardService{

	@Autowired
	private FBoardStore fStore;

//전체글갯수
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return fStore.selectListCount();
	}
//조회수 올리기
	@Override
	public int addHits(int fBoardNo) {
		// TODO Auto-generated method stub
		return fStore.addHits(fBoardNo);
	}
//전체리스트
	@Override
	public ArrayList<Freeboard> printAll(PageInfo pi) {
		// TODO Auto-generated method stub
		return fStore.selectAllList(pi);
	}
//상세조회
	@Override
	public Freeboard printOne(int fBoardNo) {
		// TODO Auto-generated method stub
		return fStore.selectOne(fBoardNo);
	}
//게시글 등록
	@Override
	public int registerFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return fStore.insertFBoard(fBoard);
	}
//파일등록
	@Override
	public Object fileUpload(String originalFileName, String renameFileName, String filePath, long fileSize) {
		HashMap<String, Object> hmap = new HashMap<>();
		hmap.put("originalFilename", originalFileName);
		hmap.put("renameFilename", renameFileName);
		hmap.put("filePath", filePath);
		hmap.put("fileSize", fileSize);
		
		return fStore.uploadFile(hmap);
	}

//파일수정
	@Override
	public int modifyFBoard(Freeboard fBoard) {
		// TODO Auto-generated method stub
		return fStore.updateFBoard(fBoard);
	}

//파일삭제
	@Override
	public int removeFBoard(int fBoardNo) {
		// TODO Auto-generated method stub
		return fStore.deleteFBoard(fBoardNo);
	}
	
//댓글리스트 조회
	@Override
	public ArrayList<FreeboardCmt> printAllCmt(int fBoardNo) {
		// TODO Auto-generated method stub
		return fStore.selectAllCmt(fBoardNo);
	}

//댓글등록
	@Override
	public int registerFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return fStore.insertFBoardCmt(fBoardCmt);
	}

	@Override
	public int modifyFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFBoardCmt(FreeboardCmt fBoardCmt) {
		// TODO Auto-generated method stub
		return 0;
	}



}
