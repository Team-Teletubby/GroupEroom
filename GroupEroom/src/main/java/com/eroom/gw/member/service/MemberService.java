package com.eroom.gw.member.service;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;

public interface MemberService {
	// 로그인
	public Member loginMember(Member member);
	//등록
	public int registerMember(Member member);
	// 정보수정
	public int modifyMember(Member member);
	//사원목록조회
	public ArrayList<Member> printAll();
	public ArrayList<Member> printSearchAll(Search search);

	public Member printMemberOne(int memberId);

	// 특정 부서 사원 목록 
	public ArrayList<Member> printdepartMentMemberAll(String depName);
	
	}
	

