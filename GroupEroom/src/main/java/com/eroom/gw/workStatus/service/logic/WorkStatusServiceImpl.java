package com.eroom.gw.workStatus.service.logic;

import org.springframework.stereotype.Service;

import com.eroom.gw.workStatus.domain.WorkStatus;
import com.eroom.gw.workStatus.service.WorkStatusService;
import com.eroom.gw.workStatus.store.WorkStatusStore;
import com.eroom.gw.workStatus.store.logic.WorkStatusStoreLogic;

@Service
public class WorkStatusServiceImpl implements WorkStatusService{

	private WorkStatusStore workStatusStore;

	/**
	 * 집무현황 등록
	 */
	@Override
	public int registerWorkMember(WorkStatus workStatus) {
		return workStatusStore.insertWorkMember(workStatus);
	}

	
}
