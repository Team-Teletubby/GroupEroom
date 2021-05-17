package com.eroom.gw.booking.domain;

public class MeetingRoom {
	
	private int roomNo;
	private String roomName;
	
	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MeetingRoom(int roomNo, String roomName) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
	}
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString() {
		return "MeetingRoom [roomNo=" + roomNo + ", roomName=" + roomName + "]";
	}
	
	

}
