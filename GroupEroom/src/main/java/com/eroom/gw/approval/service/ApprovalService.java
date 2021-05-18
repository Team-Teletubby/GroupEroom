package com.eroom.gw.approval.service;

import java.util.ArrayList;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.common.PageInfo;

public interface ApprovalService {
	

	/**
	 * 게시물 등록
	 * @param approval
	 * @return
	 */
	public int registerApproval(Approval approval);
	
	/**
	 * 게시물 전체 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Approval> printAll(PageInfo pi, String boardType);
	
	/**
	 * 게시물 상세 조회
	 * @param approvalNo
	 * @return
	 */
	public Approval printOne(int approvalNo);
	
	/**
	 * 게시물 삭제
	 * @param approvalNo
	 * @return
	 */
	public int deleteApproval(int approvalNo);

	/**
	 * 게시물 상태 변경
	 * @param approval
	 * @return
	 */
	public int changeState(Approval approval);

	/**
	 * 댓글 등록
	 * @param reply
	 * @return
	 */
	public int registerReply(ApprovalReply reply);
	
	/**
	 * 댓글 전체 조회
	 * @param approvalNo
	 * @return
	 */
	public ArrayList<ApprovalReply> printAllReply(int approvalNo);
	
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public int modityReply(ApprovalReply reply);
	
	/**
	 * 댓글 삭제
	 * @param reply
	 * @return
	 */
	public int deleteReply(ApprovalReply reply);

	
}
