package com.eroom.gw.cooperation.service;

import java.util.ArrayList;

import com.eroom.gw.cboard.domain.Reply;
import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;

public interface CooperationService {
	
	public ArrayList<CooperationRoom> printAll(); //전체조회
	public int registerRoom(CooperationRoom room); //방만들기
	public ArrayList<Cooperation> printAllByRoom(int roomNo); //상세조회
	public int registerCoop(Cooperation coop); //게시물 작성
	public int modifyCoop(Cooperation coop); //게시물 수정
	public int removeCoop(int coNo); //게시물 삭제
	
	public ArrayList<CooperationCmt> printAllCmt(int coNo); //댓글조회
	public int registerCoopCmt(CooperationCmt cmt); //댓글생성
	public int modifyCoopCmt(CooperationCmt cmt); //댓글수정
	public int removeCoopCmt(CooperationCmt cmt); //댓글삭제
	public CooperationCmt printOne(int coNo); //1개만 조회

}
