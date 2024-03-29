package com.eroom.gw.chatting.domain;


import org.springframework.web.socket.WebSocketSession;

public class Room {
	private int roomNumber; // 채팅방 번호
	private String roomName; // 채팅방이름
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	@Override
	public String toString() {
		return "ChatRoom [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
	}
	
}
