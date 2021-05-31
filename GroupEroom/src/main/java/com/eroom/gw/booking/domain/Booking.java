package com.eroom.gw.booking.domain;

import java.sql.Date;

public class Booking {
	
	private int bookingNo; // 예약번호
	private int roomNo; // 회의실 번호
	private int memberId; // 예약한 회원의 ID
	private String memberName; // 예약한 회원의 이름
	private String bookingTitle; // 예약 이름
	private String bContents; // 예약 내용
	private Date bookingCreateDate; // 생성날짜
	private Date bookingStartDate; // 회의 시작 날짜
	private Date bookingEndDate; // 회의 끝나는 날짜
	
	
	public Booking() {
		super();
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
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

	public String getBookingTitle() {
		return bookingTitle;
	}

	public void setBookingTitle(String bookingTitle) {
		this.bookingTitle = bookingTitle;
	}

	public String getbContents() {
		return bContents;
	}

	public void setbContents(String bContents) {
		this.bContents = bContents;
	}

	public Date getBookingCreateDate() {
		return bookingCreateDate;
	}

	public void setBookingCreateDate(Date bookingCreateDate) {
		this.bookingCreateDate = bookingCreateDate;
	}

	public Date getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(Date bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public Date getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(Date bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public int getJoinFirstMemberId() {
		return joinFirstMemberId;
	}

	public void setJoinFirstMemberId(int joinFirstMemberId) {
		this.joinFirstMemberId = joinFirstMemberId;
	}

	public String getJoinFirstMemberName() {
		return joinFirstMemberName;
	}

	public void setJoinFirstMemberName(String joinFirstMemberName) {
		this.joinFirstMemberName = joinFirstMemberName;
	}

	public String getJoinFirstMemberDept() {
		return joinFirstMemberDept;
	}

	public void setJoinFirstMemberDept(String joinFirstMemberDept) {
		this.joinFirstMemberDept = joinFirstMemberDept;
	}

	public String getJoinFirstMemberCheck() {
		return joinFirstMemberCheck;
	}

	public void setJoinFirstMemberCheck(String joinFirstMemberCheck) {
		this.joinFirstMemberCheck = joinFirstMemberCheck;
	}

	public int getJoinSecondMemberId() {
		return joinSecondMemberId;
	}

	public void setJoinSecondMemberId(int joinSecondMemberId) {
		this.joinSecondMemberId = joinSecondMemberId;
	}

	public String getJoinSecondMemberName() {
		return joinSecondMemberName;
	}

	public void setJoinSecondMemberName(String joinSecondMemberName) {
		this.joinSecondMemberName = joinSecondMemberName;
	}

	public String getJoinSecondMemberDept() {
		return joinSecondMemberDept;
	}

	public void setJoinSecondMemberDept(String joinSecondMemberDept) {
		this.joinSecondMemberDept = joinSecondMemberDept;
	}

	public String getJoinSecondMemberCheck() {
		return joinSecondMemberCheck;
	}

	public void setJoinSecondMemberCheck(String joinSecondMemberCheck) {
		this.joinSecondMemberCheck = joinSecondMemberCheck;
	}

	public int getJoinThirdMemberId() {
		return joinThirdMemberId;
	}

	public void setJoinThirdMemberId(int joinThirdMemberId) {
		this.joinThirdMemberId = joinThirdMemberId;
	}

	public String getJoinThirdMemberName() {
		return joinThirdMemberName;
	}

	public void setJoinThirdMemberName(String joinThirdMemberName) {
		this.joinThirdMemberName = joinThirdMemberName;
	}

	public String getJoinThirdMemberDept() {
		return joinThirdMemberDept;
	}

	public void setJoinThirdMemberDept(String joinThirdMemberDept) {
		this.joinThirdMemberDept = joinThirdMemberDept;
	}

	public String getJoinThirdMemberCheck() {
		return joinThirdMemberCheck;
	}

	public void setJoinThirdMemberCheck(String joinThirdMemberCheck) {
		this.joinThirdMemberCheck = joinThirdMemberCheck;
	}

	public int getJoinFourthMemberId() {
		return joinFourthMemberId;
	}

	public void setJoinFourthMemberId(int joinFourthMemberId) {
		this.joinFourthMemberId = joinFourthMemberId;
	}

	public String getJoinFourthMemberName() {
		return joinFourthMemberName;
	}

	public void setJoinFourthMemberName(String joinFourthMemberName) {
		this.joinFourthMemberName = joinFourthMemberName;
	}

	public String getJoinFourthMemberDept() {
		return joinFourthMemberDept;
	}

	public void setJoinFourthMemberDept(String joinFourthMemberDept) {
		this.joinFourthMemberDept = joinFourthMemberDept;
	}

	public String getJoinFourthMemberCheck() {
		return joinFourthMemberCheck;
	}

	public void setJoinFourthMemberCheck(String joinFourthMemberCheck) {
		this.joinFourthMemberCheck = joinFourthMemberCheck;
	}

	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", roomNo=" + roomNo + ", memberId=" + memberId + ", memberName="
				+ memberName + ", bookingTitle=" + bookingTitle + ", bContents=" + bContents + ", bookingCreateDate="
				+ bookingCreateDate + ", bookingStartDate=" + bookingStartDate + ", bookingEndDate=" + bookingEndDate
				+ ", joinFirstMemberId=" + joinFirstMemberId + ", joinFirstMemberName=" + joinFirstMemberName
				+ ", joinFirstMemberDept=" + joinFirstMemberDept + ", joinFirstMemberCheck=" + joinFirstMemberCheck
				+ ", joinSecondMemberId=" + joinSecondMemberId + ", joinSecondMemberName=" + joinSecondMemberName
				+ ", joinSecondMemberDept=" + joinSecondMemberDept + ", joinSecondMemberCheck=" + joinSecondMemberCheck
				+ ", joinThirdMemberId=" + joinThirdMemberId + ", joinThirdMemberName=" + joinThirdMemberName
				+ ", joinThirdMemberDept=" + joinThirdMemberDept + ", joinThirdMemberCheck=" + joinThirdMemberCheck
				+ ", joinFourthMemberId=" + joinFourthMemberId + ", joinFourthMemberName=" + joinFourthMemberName
				+ ", joinFourthMemberDept=" + joinFourthMemberDept + ", joinFourthMemberCheck=" + joinFourthMemberCheck
				+ "]";
	}

}
