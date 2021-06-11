package com.eroom.gw.workStatus.service;

import com.eroom.gw.workStatus.domain.WorkStatus;

public interface WorkStatusService {

	
	/**
	 * 집무 현황 등록
	 * @param workStatus
	 * @return
	 */
	public int registerWorkMember(WorkStatus workStatus);
}
