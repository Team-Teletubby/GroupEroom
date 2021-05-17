package com.eroom.gw.attendance.domain;

import java.sql.Date;

public class Attendance {
	
	private int attendanceNo;
	private String memberId;
	private String holidayType;
	private Date startDate;
	private Date endDate;
	private int totalHoliday;
	private int usedHoliday;
	private String reason;
	
	public Attendance() {}
	
	public int getAttendanceNo() {
		return attendanceNo;
	}
	public void setAttendanceNo(int attendanceNo) {
		this.attendanceNo = attendanceNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHolidayType() {
		return holidayType;
	}
	public void setHolidayType(String holidayType) {
		this.holidayType = holidayType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTotalHoliday() {
		return totalHoliday;
	}
	public void setTotalHoliday(int totalHoliday) {
		this.totalHoliday = totalHoliday;
	}
	public int getUsedHoliday() {
		return usedHoliday;
	}
	public void setUsedHoliday(int usedHoliday) {
		this.usedHoliday = usedHoliday;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceNo=" + attendanceNo + ", memberId=" + memberId + ", holidayType=" + holidayType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalHoliday=" + totalHoliday
				+ ", usedHoliday=" + usedHoliday + ", reason=" + reason + "]";
	}
	
	
	
}
