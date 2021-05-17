package com.eroom.gw.cooperation.store;

import java.util.ArrayList;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;

public interface CooperationStore {
	
	public ArrayList<Cooperation> selectAllList(); //게시물 리스트조회
	public int insertCooperation(Cooperation co); //게시물 작성
	public int updateCooperation(Cooperation co); //게시물 수정
	public int deleteCooperation(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> selectAllCmt(int coNo); //댓글조회
	public int insertCooperationCmt(CooperationCmt coCmt); //댓글생성
	public int updateCooperationCmt(CooperationCmt coCmt); //댓글수정
	public int deleteCooperationCmt(CooperationCmt coCmt); //댓글삭제


}
