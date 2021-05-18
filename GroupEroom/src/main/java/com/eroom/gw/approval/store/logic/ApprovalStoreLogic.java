package com.eroom.gw.approval.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.store.ApprovalStore;
import com.eroom.gw.common.PageInfo;

@Repository
public class ApprovalStoreLogic implements ApprovalStore{

	@Override
	public int insertApproval(Approval approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Approval> selectAllList(PageInfo pi, String boardType) {
		// TODO Auto-generated method stub
		
		/* sqlSession.selectList( , , ); */
		return null;
	}

	@Override
	public Approval selectOne(int approvalNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteApproval(int approvalNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateState(Approval approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ApprovalReply> selectAllList(int approvalNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

}
