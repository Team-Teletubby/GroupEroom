package com.eroom.gw.fboard.domain;

import java.sql.Timestamp;

public class FreeboardCmt {
	
	private int cmtNo;
	private String cmtContents;
	private Timestamp enrollDate;
	private int fBoardNo;
	private int memberId;
	
	public FreeboardCmt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FreeboardCmt(String cmtContents, int fBoardNo, int memberId) {
		super();
		this.cmtContents = cmtContents;
		this.fBoardNo = fBoardNo;
		this.memberId = memberId;
	}
	
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
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getfBoardNo() {
		return fBoardNo;
	}
	public void setfBoardNo(int fBoardNo) {
		this.fBoardNo = fBoardNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "FreeboardCmt [cmtNo=" + cmtNo + ", cmtContents=" + cmtContents + ", enrollDate=" + enrollDate
				+ ", fBoardNo=" + fBoardNo + ", memberId=" + memberId + "]";
	}
	
	

}
