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

	// 진행함 글 리스트(페이징o)
	@Override
	public ArrayList<Approval> printAll(PageInfo pi, Approval approval) {
		return approvalStore.selectList(pi, approval);
	}
	
	// 진행함 글 리스트(페이징x)
	@Override
	public ArrayList<Approval> printAll(int memberId) {
		return approvalStore.selectList(memberId);
	}

	// 글 상세보기
	@Override
	public Approval printOne(int approvalNo) {
		return approvalStore.selectOne(approvalNo);
	}

	@Override
	public int deleteApproval(int approvalNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 글 상태 변경
	@Override
	public int changeState(Approval approval) {
		return approvalStore.updateState(approval);
	}

	// 승인/반려 버튼
	@Override
	public int changeCheck(Approval approval) {
		return approvalStore.updateCheck(approval);
	}
	
	// 조건에 맞는 글 갯수 가져오기
	@Override
	public int getListCount(Approval approval) {
		return approvalStore.selectListCount(approval);
	}
	
	//================ 댓글 ================
	// 댓글 등록
	@Override
	public int registerReply(ApprovalReply reply) {
		return approvalStore.insertReply(reply);
	}
	
	// 댓글 리스트
	@Override
	public ArrayList<ApprovalReply> printAllReply(int approvalNo) {
		return approvalStore.selectAllList(approvalNo);
	}

	@Override
	public int modityReply(ApprovalReply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 댓글 삭제
	@Override
	public int deleteReply(ApprovalReply reply) {
		return approvalStore.deleteReply(reply);
	}

	//================ 파일 ================
	// 파일 등록
	@Override
	public int registerFile(ApprovalFile aFile) {
		return approvalStore.insertFile(aFile);
	}

	// 파일 가져오기
	@Override
	public ArrayList<ApprovalFile> printFile(int approvalNo) {
		return approvalStore.selectFile(approvalNo);
	}
	
	
	
	// 안읽은 결재문 개수 출력
	@Override
	public int printTypeCount(int memberId) {
		return approvalStore.selectTypeCount(memberId);
	}


}
