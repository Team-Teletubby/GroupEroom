package com.eroom.gw.calendar.domain;

import java.sql.Date;

public class Calendar {
	
	private int calNo;
	private int memberId;
	private String memberName;
	private String calType;
	private String calTitle;
	private String calInfo;
	private String startDate;
	private String endDate;
	
	public Calendar() {}

	public int getCalNo() {
		return calNo;
	}

	public void setCalNo(int calNo) {
		this.calNo = calNo;
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

	public String getCalType() {
		return calType;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}

	public String getCalTitle() {
		return calTitle;
	}

	public void setCalTitle(String calTitle) {
		this.calTitle = calTitle;
	}

	public String getCalInfo() {
		return calInfo;
	}

	public void setCalInfo(String calInfo) {
		this.calInfo = calInfo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Calendar [calNo=" + calNo + ", memberId=" + memberId + ", memberName=" + memberName + ", calType="
				+ calType + ", calTitle=" + calTitle + ", calInfo=" + calInfo + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	
}
