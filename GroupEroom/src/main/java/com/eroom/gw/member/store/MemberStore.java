package com.eroom.gw.member.store;

import java.util.ArrayList;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.member.domain.Search;

public interface MemberStore {
	
	public ArrayList<Member> selectList();
	public ArrayList<Member> selectSearchList(Search search);
	public Member selectOne(int mId);
	public int insertMember(Member member);
	public int updateMember(Member member);
}
