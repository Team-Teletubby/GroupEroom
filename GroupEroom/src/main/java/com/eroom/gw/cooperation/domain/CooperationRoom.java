package com.eroom.gw.cooperation.domain;

public class CooperationRoom {
	
	private int roomNo;
	private String roomName;
	private int memberId;
	private String roomAdmin;
	private String status;
	
	public CooperationRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CooperationRoom(int roomNo, String roomName, String roomAdmin, int memberId, String status) {
		super();
		this.roomNo = roomNo;
		this.roomName = roomName;
		this.roomAdmin = roomAdmin;
		this.memberId = memberId;
		this.status = status;
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

	public String getRoomAdmin() {
		return roomAdmin;
	}

	public void setRoomAdmin(String roomAdmin) {
		this.roomAdmin = roomAdmin;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CooperationRoom [roomNo=" + roomNo + ", roomName=" + roomName + ", roomAdmin=" + roomAdmin
				+ ", memberId=" + memberId + ", status=" + status + "]";
	}
	
	
}
