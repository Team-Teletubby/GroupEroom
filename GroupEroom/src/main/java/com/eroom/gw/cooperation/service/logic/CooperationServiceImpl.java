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
	public Cooperation printOne(int roomNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCoop(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCoop(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCoop(int coNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CooperationCmt> printAllCmt(int coNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCoopCmt(CooperationCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCoopCmt(CooperationCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCoopCmt(CooperationCmt cmt) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
