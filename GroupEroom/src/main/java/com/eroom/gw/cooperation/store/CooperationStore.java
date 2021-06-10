package com.eroom.gw.cooperation.store;

import java.util.ArrayList;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;

public interface CooperationStore {
	
	public ArrayList<CooperationRoom> selectAllList(); //방 리스트조회
	public ArrayList<Cooperation> selectAllByRoom(int roomNo); //협업 상세조회
	public int insertCoop(Cooperation coop); //게시물 작성
	public int updateCoop(Cooperation coop); //게시물 수정
	public int deleteCoop(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> selectAllCmt(int coNo); //댓글조회
	public int insertCoopCmt(CooperationCmt cmt); //댓글생성
	public int updateCoopCmt(CooperationCmt cmt); //댓글수정
	public int deleteCoopCmt(CooperationCmt cmt); //댓글삭제


}
