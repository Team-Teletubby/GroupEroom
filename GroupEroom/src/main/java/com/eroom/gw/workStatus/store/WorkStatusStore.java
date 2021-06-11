package com.eroom.gw.workStatus.store;

import com.eroom.gw.workStatus.domain.WorkStatus;

public interface WorkStatusStore  {

	/**
	 * 집무 현황 등록
	 * @param workStaxtus
	 * @return
	 */
	int insertWorkMember(WorkStatus workStaxtus);

}
