package com.eroom.gw.cboard.domain;

import java.sql.Date;

public class CBoardCmt {
	
	private int cmtNo;
	private String cmtContents;
	private Date enrollDate;
	private int cBoardNo;
	private int memberId;
	private String memberName;
	
	public CBoardCmt() {}

	public int getCmtNo() {
		return cmtNo;
	}

	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}

	public String getCmtContents() {
		return cmtContents;
	}

	public void setCmtContents(String cmtContents) {
		this.cmtContents = cmtContents;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Cmt [cmtNo=" + cmtNo + ", cmtContents=" + cmtContents + ", enrollDate=" + enrollDate + ", cBoardNo="
				+ cBoardNo + ", memberId=" + memberId + ", memberName=" + memberName + "]";
	};
	
	
	

}
