package com.eroom.gw.member.store;

import java.util.ArrayList;
import java.util.List;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;

public interface MemberStore {
	
	public List<Member> selectList();
	public ArrayList<Member> selectSearchList(Search search);
	public Member selectOne(Member member);
	public int insertMember(Member member);
	public int updateMember(Member member);
	public ArrayList<Member> selectDepartMentMember(String depName);
}
