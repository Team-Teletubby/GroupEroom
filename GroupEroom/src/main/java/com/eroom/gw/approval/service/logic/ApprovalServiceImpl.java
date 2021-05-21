package com.eroom.gw.approval.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalFile;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.service.ApprovalService;
import com.eroom.gw.approval.store.ApprovalStore;
import com.eroom.gw.common.PageInfo;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalStore approvalStore;
	
	// 결재 등록
	@Override
	public int registerApproval(Approval approval) {
		return approvalStore.insertApproval(approval);
	}

	@Override
	public ArrayList<Approval> printAll(PageInfo pi, String boardType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Approval printOne(int approvalNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteApproval(int approvalNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changeState(Approval approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int registerReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ApprovalReply> printAllReply(int approvalNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modityReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 파일 등록
	@Override
	public int registerFile(ApprovalFile file) {
		return approvalStore.insertFile(file);
	}

}
