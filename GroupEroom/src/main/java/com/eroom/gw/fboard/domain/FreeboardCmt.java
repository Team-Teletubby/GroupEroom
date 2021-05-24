package com.eroom.gw.fboard.domain;

import java.sql.Timestamp;

public class FreeboardCmt {
	
	private int cmtNo;
	private String cmtContents;
	private Timestamp enrollDate;
	private int fBoardNo;
	private int memberId;
	private String cmtStatus;
	private String cmtWriter;
	public FreeboardCmt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FreeboardCmt(int cmtNo, String cmtContents, Timestamp enrollDate, int fBoardNo, int memberId, String cmtStatus,
			String cmtWriter) {
		super();
		this.cmtNo = cmtNo;
		this.cmtContents = cmtContents;
		this.enrollDate = enrollDate;
		this.fBoardNo = fBoardNo;
		this.memberId = memberId;
		this.cmtStatus = cmtStatus;
		this.cmtWriter = cmtWriter;
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
	public String getCmtWriter() {
		return cmtWriter;
	}
	public void setCmtWriter(String cmtWriter) {
		this.cmtWriter = cmtWriter;
	}
	public String getCmtStatus() {
		return cmtStatus;
	}
	public void setCmtStatus(String cmtStatus) {
		this.cmtStatus = cmtStatus;
	}
	@Override
	public String toString() {
		return "FreeboardCmt [cmtNo=" + cmtNo + ", cmtContents=" + cmtContents + ", enrollDate=" + enrollDate
				+ ", fBoardNo=" + fBoardNo + ", memberId=" + memberId + ", cmtStatus=" + cmtStatus + ", cmtWriter="
				+ cmtWriter + "]";
	}
	
	
	
	
	
	

}
