package com.eroom.gw.cooperation.store;

import java.util.ArrayList;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;

public interface CooperationStore {
	
	public ArrayList<CooperationRoom> selectAllList(); //리스트조회
	public Cooperation selectOne(int roomNo);
	public int insertCoop(Cooperation co); //게시물 작성
	public int updateCoop(Cooperation co); //게시물 수정
	public int deleteCoop(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> selectAllCmt(int coNo); //댓글조회
	public int insertCoopCmt(CooperationCmt cmt); //댓글생성
	public int updateCoopCmt(CooperationCmt cmt); //댓글수정
	public int deleteCoopCmt(CooperationCmt cmt); //댓글삭제


}
