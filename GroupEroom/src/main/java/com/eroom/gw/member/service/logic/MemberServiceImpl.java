package com.eroom.gw.member.service.logic;

import java.util.ArrayList;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Member> printAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Member> printSearchAll(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member printMemberOne(int mId) {
		// TODO Auto-generated method stub
		return null;
	}

}
