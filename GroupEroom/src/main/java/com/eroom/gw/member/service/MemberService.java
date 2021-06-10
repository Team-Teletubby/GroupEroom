package com.eroom.gw.member.service;

import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import com.eroom.gw.common.PageInfo;
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
	public ArrayList<Member> printAll(PageInfo pi);
	public ArrayList<Member> printSearchAll(Search search, PageInfo pi);

	public Member printMemberOne(int memberId);

	// 특정 부서 사원 목록 
	public ArrayList<Member> printdepartMentMemberAll(String depName); //전자결재
	public ArrayList<Member> printMemberUsedDept(String deptName); //메일
	
	// 이메일 중복체크
	public int checkemId(String memberEmail);
	//페이징
	public int getListCount();
	public int getSearchListCount(Search search);
	
	// 비밀번호 변경
	public int modifymemberPwd (Member member);

	
	// 비밀번호 중복체크
	public int pwdcheck(String memberPwd);
	
	public Member printSuccessMemberOne(Member member);
	
	// 해당하는 특정 부서의 임원들만 가져오기
	public ArrayList<Member> printExecutives(Member member);
	
	}
	

