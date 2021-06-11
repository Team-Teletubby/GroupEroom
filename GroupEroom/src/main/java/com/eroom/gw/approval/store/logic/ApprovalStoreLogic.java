package com.eroom.gw.approval.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.approval.domain.Approval;
import com.eroom.gw.approval.domain.ApprovalFile;
import com.eroom.gw.approval.domain.ApprovalReply;
import com.eroom.gw.approval.store.ApprovalStore;
import com.eroom.gw.common.PageInfo;

@Repository
public class ApprovalStoreLogic implements ApprovalStore{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 결재 등록
	@Override
	public int insertApproval(Approval approval) {
		return sqlSession.insert("approvalMapper.insertApproval", approval);
	}

	// 진행함 글 리스트(페이징o)
	@Override
	public ArrayList<Approval> selectList(PageInfo pi, Approval approval) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("approvalMapper.selectList", approval, rowBounds);
	}
	
	// 진행함 글 리스트(페이징x)
	@Override
	public ArrayList<Approval> selectList(int memberId) {
		return (ArrayList)sqlSession.selectList("approvalMapper.selectList2", memberId);
	}
	
	// 글 상세보기
	@Override
	public Approval selectOne(int approvalNo) {
		return sqlSession.selectOne("approvalMapper.selectOne", approvalNo);
	}

	@Override
	public int deleteApproval(int approvalNo) {
		return 0;
	}

	// 조건에 맞는 글 갯수 가져오기
	@Override
	public int selectListCount(Approval approval) {
		return sqlSession.selectOne("approvalMapper.selectListCount", approval);
	}
	
	// 글 상태 변경
	@Override
	public int updateState(Approval approval) {
		return sqlSession.update("approvalMapper.updateApprovalState", approval);
	}
	
	// 승인/반려 버튼
	@Override
	public int updateCheck(Approval approval) {
		return sqlSession.update("approvalMapper.updateApprovalCheck", approval);
	}
	
	//================ 댓글 ================
	// 댓글 등록
	@Override
	public int insertReply(ApprovalReply reply) {
		return sqlSession.insert("approvalMapper.insertReply", reply);
	}

	// 댓글 리스트
	@Override
	public ArrayList<ApprovalReply> selectAllList(int approvalNo) {
		return (ArrayList)sqlSession.selectList("approvalMapper.selectListReply", approvalNo);
	}

	@Override
	public int updateReply(ApprovalReply reply) {
		return 0;
	}

	@Override
	public int deleteReply(ApprovalReply reply) {
		return 0;
	}

	// 파일 등록
	@Override
	public int insertFile(ApprovalFile aFile) {
		return sqlSession.insert("approvalMapper.insertFile", aFile);
	}

	// 안읽은 결재문 개수 출력
	@Override
	public int selectTypeCount(int memberId) {
		return sqlSession.selectOne("approvalMapper.selectTypeCount", memberId);
	}



}
