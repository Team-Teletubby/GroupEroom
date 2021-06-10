package com.eroom.gw.member.store;

import java.util.ArrayList;

import com.eroom.gw.common.PageInfo;
import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;

public interface MemberStore {
	
	public ArrayList<Member> selectList(PageInfo pi);
	public ArrayList<Member> selectSearchList(Search search,PageInfo pi );
	public Member selectOne(Member member);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public ArrayList<Member> selectDepartMentMember(String depName); //전자결재
	public ArrayList<Member> selectMemberUsedDept(String deptName); //메일
	public Member selectOneById(int memberId);
	public Member detailMember(int memberId);

	public int checkemId(String memberEmail);
	
	public int selectListCount();
	public int selectSearchListCount(Search search);
	
	public int updatememberPwd(Member member);
	
	public int pwdcheck(String memberPwd);
	
	public Member selectSuccessOne(Member member);
	
	// 특정 부서별 임원 조회
	public ArrayList<Member> selectListExecutives(Member member);
}
