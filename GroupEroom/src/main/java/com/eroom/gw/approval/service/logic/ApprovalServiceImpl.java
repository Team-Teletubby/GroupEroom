package com.eroom.gw.approval.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.service.ApprovalService;
import com.eroom.gw.approval.store.ApprovalStore;
import com.eroom.gw.common.PageInfo;

@Service
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalStore approvalStore;
	
	@Override
	public int registerApproval(Approval approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Approval> printAll(PageInfo pi) {
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

}
