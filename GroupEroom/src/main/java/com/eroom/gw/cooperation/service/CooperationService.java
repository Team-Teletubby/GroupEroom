package com.eroom.gw.cooperation.service;

import java.util.ArrayList;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;

public interface CooperationService {
	
	public ArrayList<Cooperation> printAll(); //게시물 리스트조회
	public int registerCoop(Cooperation co); //게시물 작성
	public int modifyCoop(Cooperation co); //게시물 수정
	public int removeCoop(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> printAllCmt(int coNo); //댓글조회
	public int registerCoopCmt(CooperationCmt cmt); //댓글생성
	public int modifyCoopCmt(CooperationCmt cmt); //댓글수정
	public int removeCoopCmt(CooperationCmt cmt); //댓글삭제

}
