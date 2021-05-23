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
	public List<Member> selectList() {
		return sqlSession.selectList("memberMapper.memberList");
	}

	@Override
	public ArrayList<Member> selectSearchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOne(Member member) {
		Member loginUser = sqlSession.selectOne("memberMapper.loginMember", member);
		return loginUser;
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
	
}
