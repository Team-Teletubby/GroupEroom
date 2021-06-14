package com.eroom.gw.cooperation.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.domain.CooperationRoom;
import com.eroom.gw.cooperation.service.CooperationService;
import com.eroom.gw.cooperation.store.CooperationStore;

@Service
public class CooperationServiceImpl implements CooperationService {

	@Autowired
	private CooperationStore coStore;

	@Override
	public ArrayList<CooperationRoom> printAll() {
		return coStore.selectAllList();
	}

	@Override
	public int registerRoom(CooperationRoom room) {
		return coStore.insertRoom(room);
	}

	@Override
	public ArrayList<Cooperation> printAllByRoom(int roomNo) {
		return coStore.selectAllByRoom(roomNo);
	}

	@Override
	public int registerCoop(Cooperation coop) {
		return coStore.insertCoop(coop);
	}

	@Override
	public int modifyCoop(Cooperation coop) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCoop(int coNo) {
		return coStore.deleteCoop(coNo);
	}

	@Override
	public ArrayList<CooperationCmt> printAllCmt(int coNo) {
		return coStore.selectAllCmt(coNo);
	}

	@Override
	public int registerCoopCmt(CooperationCmt cmt) {
		return coStore.insertCoopCmt(cmt);
	}

	@Override
	public int modifyCoopCmt(CooperationCmt cmt) {
		return coStore.updateCoopCmt(cmt);
	}

	@Override
	public int removeCoopCmt(CooperationCmt cmt) {
		return coStore.deleteCoopCmt(cmt);
	}

	@Override
	public CooperationCmt printOne(int coNo) {
		return coStore.selectOne(coNo);
	}

	
	

}
