package com.eroom.gw.attendance.domain;

import java.sql.Date;

public class Attendance {
	
	private int attendanceNo;
	private int memberId;
	private String holidayType;
	private Date startDate;
	private Date endDate;
	private int totalHoliday;
	private float usedHoliday;
	private String reason;
	private String done;
	
	public Attendance() {}
	
	public int getAttendanceNo() {
		return attendanceNo;
	}
	public void setAttendanceNo(int attendanceNo) {
		this.attendanceNo = attendanceNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
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
	public float getUsedHoliday() {
		return usedHoliday;
	}
	public void setUsedHoliday(float usedHoliday) {
		this.usedHoliday = usedHoliday;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getDone() {
		return done;
	}

	public void setDone(String done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Attendance [attendanceNo=" + attendanceNo + ", memberId=" + memberId + ", holidayType=" + holidayType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalHoliday=" + totalHoliday
				+ ", usedHoliday=" + usedHoliday + ", reason=" + reason + ", done=" + done + "]";
	}


	
	
}
