package com.eroom.gw.member.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;

public interface MemberService {

	public Member loginMember(Member member);
	public int registerMember(Member member);
	public int modifyMember(Member member);
	//사원목록 
	public List<Member> printAll();
	public ArrayList<Member> printSearchAll(Search search);

	public Member printMemberOne(int mId);

	}
	

