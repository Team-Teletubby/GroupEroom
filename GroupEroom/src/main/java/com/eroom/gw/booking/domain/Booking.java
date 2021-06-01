package com.eroom.gw.booking.domain;

import java.util.Date;

public class Booking {
	
	private int _id; // 예약번호
	private int roomNo; // 회의실 번호
	private int memberId; // 예약한 회원의 ID
	private String username; // 예약한 회원의 이름
	private String userDept;
	private String title; // 예약 이름
	private String description; // 예약 내용
	private String bookingCreateDate; // 생성날짜
	private String start; // 회의 시작 날짜
	private String end; // 회의 끝나는 날짜
	
	public Booking() {
		super();
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookingCreateDate() {
		return bookingCreateDate;
	}

	public void setBookingCreateDate(String bookingCreateDate) {
		this.bookingCreateDate = bookingCreateDate;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	@Override
	public String toString() {
		return "Booking [_id=" + _id + ", roomNo=" + roomNo + ", memberId=" + memberId + ", username=" + username
				+ ", userDept=" + userDept + ", title=" + title + ", description=" + description
				+ ", bookingCreateDate=" + bookingCreateDate + ", start=" + start + ", end=" + end + "]";
	}

	
}