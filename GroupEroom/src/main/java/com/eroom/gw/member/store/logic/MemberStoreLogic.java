package com.eroom.gw.member.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Member> selectList(PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("memberMapper.memberList", null, rowBounds);
	}

	//검색
	@Override
	public ArrayList<Member> selectSearchList(Search search, PageInfo pi) {
		int offset = (pi.getCurrentPage() -1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("memberMapper.selectSearchList", search, rowBounds);
	}

	//멤버 한명 선택
	@Override
	public Member selectOne(Member member) {
		Member memberOne = sqlSession.selectOne("memberMapper.loginMember", member);
		return memberOne;
	}

	@Override
	public int insertMember(Member member) {
		int result = sqlSession.insert("memberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMember(Member member) {
		int result= sqlSession.update("memberMapper.updateMember", member);
		return result;
	}

	// 특정부서의 멤버목록
	@Override
	public ArrayList<Member> selectDepartMentMember(String depName) {
		return (ArrayList)sqlSession.selectList("memberMapper.selectDepMemberList", depName); //전자결재
	}
	@Override
	public ArrayList<Member> selectMemberUsedDept(String deptName) { 
		return (ArrayList)sqlSession.selectList("memberMapper.selectDeptMemberList", deptName); //메일
	}

	@Override
	public Member selectOneById(int memberId) {
		return sqlSession.selectOne("memberMapper.selectOneMember", memberId);
	}

	@Override
	public Member detailMember(int memberId) {
		return sqlSession.selectOne("memberMapper.selectOneMember", memberId);
	}

	@Override
	public int checkemId(String memberEmail) {
		return sqlSession.selectOne("memberMapper.checkemId", memberEmail);
	}


	@Override
	public int selectListCount() {
	
		return sqlSession.selectOne("memberMapper.selectListCount");
	}


	

	@Override
	public int selectSearchListCount(Search search) {
		return sqlSession.selectOne("memberMapper.selectSearchListCount", search);
	}

	@Override
	public int updatememberPwd(Member member) {
	
		int result=  sqlSession.update("memberMapper.updatememberPwd", member);
		return result;
	}

	@Override
	public int pwdcheck(String memberPwd) {
		return sqlSession.selectOne("memberMapper.pwdcheck", memberPwd);
	}

	
	
}
