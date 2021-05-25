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

	// 글 리스트
	@Override
	public ArrayList<Approval> selectAllList(PageInfo pi, Approval approval) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("approvalMapper.selectList", approval, rowBounds);
	}

	// 글 상세보기
	@Override
	public Approval selectOne(int approvalNo) {
		return sqlSession.selectOne("approvalMapper.selectOne", approvalNo);
	}

	@Override
	public int deleteApproval(int approvalNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 조건에 맞는 글 갯수 가져오기
	@Override
	public int selectListCount(String boardType) {
		return sqlSession.selectOne("approvalMapper.selectListCount", boardType);
	}
	
	// 글 상태 변경
	@Override
	public int updateState(Approval approval) {
		return sqlSession.update("approvalMapper.updateApprovalState", approval);
	}
	
	//================ 댓글 ================
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

	// 파일 등록
	@Override
	public int insertFile(ApprovalFile aFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("approvalMapper.insertFile", aFile);
	}

}
