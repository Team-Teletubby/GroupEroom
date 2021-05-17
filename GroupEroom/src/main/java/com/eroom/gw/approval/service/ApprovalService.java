package com.eroom.gw.approval.service;

import java.util.ArrayList;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.fboard.domain.PageInfo;


/**
 * @author gkdia
 *
 */
/**
 * @author gkdia
 *
 */
public interface ApprovalService {
	

	/**
	 * 게시물 등록
	 * @param approval
	 * @return
	 */
	public int approvalRegister(Approval approval);
	
	/**
	 * 게시물 전체 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Approval> printAll(PageInfo pi);
	
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
	public int approvalDelete(int approvalNo);
	

	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return
	 */
	public int replyRegister(ApprovalReply reply);
	
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
	public int replyModity(ApprovalReply reply);
	
	/**
	 * 댓글 삭제
	 * @param reply
	 * @return
	 */
	public int replyDelete(ApprovalReply reply);
	
	
}
