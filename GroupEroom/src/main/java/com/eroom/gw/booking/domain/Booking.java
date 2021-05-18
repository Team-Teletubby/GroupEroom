package com.eroom.gw.booking.domain;

import java.sql.Date;

public class Booking {
	
	private int bookingNo;
	private String bookingDate;
	private int memberId;
	private int roomNo;
	private String joinMember;
	private String bookingTime;
	private String bContents;
	private String bStatus;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingNo, String bookingDate, int memberId, int roomNo, String joinMember, String bookingTime,
			String bContents, String bStatus) {
		super();
		this.bookingNo = bookingNo;
		this.bookingDate = bookingDate;
		this.memberId = memberId;
		this.roomNo = roomNo;
		this.joinMember = joinMember;
		this.bookingTime = bookingTime;
		this.bContents = bContents;
		this.bStatus = bStatus;
	}
	
	public int getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getJoinMember() {
		return joinMember;
	}
	public void setJoinMember(String joinMember) {
		this.joinMember = joinMember;
	}
	public String getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getbContents() {
		return bContents;
	}
	public void setbContents(String bContents) {
		this.bContents = bContents;
	}
	public String getbStatus() {
		return bStatus;
	}
	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", bookingDate=" + bookingDate + ", memberId=" + memberId
				+ ", roomNo=" + roomNo + ", joinMember=" + joinMember + ", bookingTime=" + bookingTime + ", bContents="
				+ bContents + ", bStatus=" + bStatus + "]";
	}
	
	
}
