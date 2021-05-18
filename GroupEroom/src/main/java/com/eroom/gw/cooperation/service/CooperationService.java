package com.eroom.gw.cooperation.service;

import java.util.ArrayList;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;

public interface CooperationService {
	
	public ArrayList<Cooperation> printAll(); //게시물 리스트조회
	public int registerCooperation(Cooperation co); //게시물 작성
	public int modifyCooperation(Cooperation co); //게시물 수정
	public int removeCooperation(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> printAllCmt(int coNo); //댓글조회
	public int registerCoCmt(CooperationCmt coCmt); //댓글생성
	public int modifyCoCmt(CooperationCmt coCmt); //댓글수정
	public int removeCoCmt(CooperationCmt coCmt); //댓글삭제

}
