package com.eroom.gw.booking.domain;

import java.sql.Date;

public class Booking {
	
	private int bookingNo;
	private int roomNo;
	private int memberId;
	private String participants;
	private Date startTime;
	private Date endTime;
	private String Contents;
	private String roomState;
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booking(int bookingNo, int roomNo, int memberId, String participants, Date startTime, Date endTime,
			String contents, String roomState) {
		super();
		this.bookingNo = bookingNo;
		this.roomNo = roomNo;
		this.memberId = memberId;
		this.participants = participants;
		this.startTime = startTime;
		this.endTime = endTime;
		Contents = contents;
		this.roomState = roomState;
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
	public String getParticipants() {
		return participants;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public String getRoomState() {
		return roomState;
	}
	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}
	
	@Override
	public String toString() {
		return "Booking [bookingNo=" + bookingNo + ", roomNo=" + roomNo + ", memberId=" + memberId + ", participants="
				+ participants + ", startTime=" + startTime + ", endTime=" + endTime + ", Contents=" + Contents
				+ ", roomState=" + roomState + "]";
	}

	
}
