package com.eroom.gw.cooperation.domain;

import java.sql.Date;

public class CooperationCmt {
	
	private int cmtNo;
	private String cmtContents;
	private Date enrollDate;
	private int coNo;
	private int memberId;
	
	public CooperationCmt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CooperationCmt(int cmtNo, String cmtContents, Date enrollDate, int coNo, int memberId) {
		super();
		this.cmtNo = cmtNo;
		this.cmtContents = cmtContents;
		this.enrollDate = enrollDate;
		this.coNo = coNo;
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
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public int getCoNo() {
		return coNo;
	}
	public void setCoNo(int coNo) {
		this.coNo = coNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "CooperationCmt [cmtNo=" + cmtNo + ", cmtContents=" + cmtContents + ", enrollDate=" + enrollDate
				+ ", coNo=" + coNo + ", memberId=" + memberId + "]";
	}
	
	

}
