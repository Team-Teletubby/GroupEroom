package com.eroom.gw.member.service.logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;
import com.eroom.gw.member.service.MemberService;
import com.eroom.gw.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService {

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
	public List<Member> printAll() {
		return mStore.selectList();
	}

	@Override
	public ArrayList<Member> printSearchAll(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member printMemberOne(int mId) {
		return mStore.selectOneById(mId);
	}
	
	@Override
	public ArrayList<Member> printdepartMentMemberAll(String depName) {
		return mStore.selectDepartMentMember(depName);
	}


	}

