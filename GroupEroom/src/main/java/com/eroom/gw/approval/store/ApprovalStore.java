package com.eroom.gw.approval.store;

import java.awt.List;
import java.util.ArrayList;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalFile;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.common.PageInfo;

/**
 * @author gkdia
 *
 */
public interface ApprovalStore {

	/**
	 * 게시물 등록
	 * @param approval
	 * @return
	 */
	public int insertApproval(Approval approval);
	
	/**
	 * 게시물 전체 조회(페이징o)
	 * @param pi, approval
	 * @return
	 */
	public ArrayList<Approval> selectList(PageInfo pi, Approval approval);
	
	/**
	 * 게시물 전체 조회(페이징x)
	 * @param approval
	 * @return
	 */
	public ArrayList<Approval> selectList(int memberId);
	
	/**
	 * 게시물 상세 조회
	 * @param approvalNo
	 * @return
	 */
	public Approval selectOne(int approvalNo);
	
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
	public int updateState(Approval approval);
	
	/**
	 * 승인/반려 버튼
	 * @param approval
	 * @return
	 */
	public int updateCheck(Approval approval);
	
	/**
	 * 조건에 맞는 글 갯수 가져오기
	 * @param approval
	 * @return
	 */
	public int selectListCount(Approval approval);
	
	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return
	 */
	public int insertReply(ApprovalReply reply);
	
	/**
	 * 댓글 전체 조회
	 * @param approvalNo
	 * @return
	 */
	public ArrayList<ApprovalReply> selectAllList(int approvalNo);
	
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public int updateReply(ApprovalReply reply);
	
	/**
	 * 댓글 수정
	 * @param reply
	 * @return
	 */
	public int deleteReply(ApprovalReply reply);

	/**
	 * 파일 등록
	 * @param file
	 * @return
	 */
	public int insertFile(ApprovalFile file);

	/**
	 * 파일 가져오기
	 * @param approvalNo
	 * @return
	 */
	public ArrayList<ApprovalFile> selectFile(int approvalNo);
	
	/**
	 * 안읽은 결재문 개수 출력
	 * @param memberId
	 * @return
	 */
	public int selectTypeCount(int memberId);




}
