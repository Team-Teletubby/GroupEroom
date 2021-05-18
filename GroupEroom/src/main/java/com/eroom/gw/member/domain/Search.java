package com.eroom.gw.member.domain;

// 전자결재 검색
public class Search {
	
	// 멤버변수
	private String searchCondition; // 검색타입(이름/내용/제목..)
	private String searchValue; // 검색어(검색내용)
	
	// 생성자
	public Search() {
		super();
	}

	public Search(String searchCondition, String searchValue) {
		super();
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
	}

	// getter/setter
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	// toString
	@Override
	public String toString() {
		return "approvalSearch [searchCondition=" + searchCondition + ", searchValue=" + searchValue + "]";
	}

}
