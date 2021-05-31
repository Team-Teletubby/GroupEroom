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

	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", roomNo=" + roomNo + ", memberId=" + memberId + ", memberName="
				+ memberName + ", bookingTitle=" + bookingTitle + ", bContents=" + bContents + ", bookingCreateDate="
				+ bookingCreateDate + ", bookingStartDate=" + bookingStartDate + ", bookingEndDate=" + bookingEndDate
				+ "]";
	}

}