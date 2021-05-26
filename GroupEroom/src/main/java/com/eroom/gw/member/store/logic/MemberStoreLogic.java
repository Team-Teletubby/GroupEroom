package com.eroom.gw.member.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Member> selectList() {
		return (ArrayList)sqlSession.selectList("memberMapper.memberList");
	}

	//검색
	@Override
	public ArrayList<Member> selectSearchList(Search search) {

		return (ArrayList)sqlSession.selectList("memberMapper.selectSearchList", search);
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
		return (ArrayList)sqlSession.selectList("memberMapper.selectDepMemberList", depName);
	}

	@Override
	public Member selectOneById(int memberId) {
		return sqlSession.selectOne("memberMapper.selectOneMember", memberId);
	}

	@Override
	public Member detailMember(int memberId) {
		return sqlSession.selectOne("memberMapper.selectOneMember", memberId);
	}
	
}
