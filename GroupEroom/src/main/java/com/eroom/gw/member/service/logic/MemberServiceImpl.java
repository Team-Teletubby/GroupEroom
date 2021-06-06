package com.eroom.gw.member.service.logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;
import com.eroom.gw.member.store.MemberStore;

@Service
public  class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberStore mStore;
	
	@Override
	public Member loginMember(Member member) {
		
		return mStore.selectOne(member);
	}

	@Override
	public int registerMember(Member member) {
		int result = mStore.insertMember(member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		int result = mStore.updateMember(member);
		return result;
	}

	@Override
	public ArrayList<Member> printAll(PageInfo pi) {
		return mStore.selectList(pi);
	}

	@Override
	public ArrayList<Member> printSearchAll(Search search, PageInfo pi) {
		ArrayList<Member> searchList = mStore.selectSearchList(search, pi);
		return searchList;
	}

	@Override
	public Member printMemberOne(int memberId) {
		return mStore.selectOneById(memberId);
	}
	
	@Override
	public ArrayList<Member> printdepartMentMemberAll(String depName) {
		return mStore.selectDepartMentMember(depName);
	}

	@Override
	public int checkemId(String memberEmail) {
		return mStore.checkemId(memberEmail);
	}

	@Override
	public int getListCount() {
		return mStore.selectListCount();
	}
	@Override
	public int getSearchListCount(Search search) {
		return mStore.selectSearchListCount(search);
	}

	@Override
	public int modifymemberPwd(Member member) {

		int result= mStore.updatememberPwd(member);
		return result;
	}




	}

