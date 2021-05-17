package com.eroom.gw.cooperation.service.logic;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.eroom.gw.cooperation.domain.Cooperation;
import com.eroom.gw.cooperation.domain.CooperationCmt;
import com.eroom.gw.cooperation.service.CooperationService;

@Service
public class CooperationServiceImpl implements CooperationService {

	@Override
	public ArrayList<Cooperation> printAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCooperation(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCooperation(Cooperation co) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCooperation(int coNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CooperationCmt> printAllCmt(int coNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerCoCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCoCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCoCmt(CooperationCmt coCmt) {
		// TODO Auto-generated method stub
		return 0;
	}

}
