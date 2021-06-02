package com.eroom.gw.chatting.domain;

public class Chat {
	private int chatNo;
	private int userId;
	private String userName;
	private int roomNumber;
	private String type;
	private String msg;
	private String chatCreateDate;
	public int getChatNo() {
		return chatNo;
	}
	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getChatCreateDate() {
		return chatCreateDate;
	}
	public void setChatCreateDate(String chatCreateDate) {
		this.chatCreateDate = chatCreateDate;
	}
	
	@Override
	public String toString() {
		return "Chat [chatNo=" + chatNo + ", userId=" + userId + ", userName=" + userName + ", roomNumber=" + roomNumber
				+ ", type=" + type + ", msg=" + msg + ", chatCreateDate=" + chatCreateDate + "]";
	}
	
}
