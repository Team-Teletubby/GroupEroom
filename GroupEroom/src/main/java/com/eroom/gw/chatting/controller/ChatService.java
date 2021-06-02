package com.eroom.gw.chatting.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.chatting.domain.Chat;
import com.eroom.gw.chatting.domain.Room;
import com.eroom.gw.chatting.store.ChatStore;

@Service
public class ChatService {
	
//	======== 채팅방 ========
	@Autowired
	private ChatStore chatStore;
	
	// 채팅방 리스트
	public ArrayList<Room> printChatRoom() {
		return chatStore.selectChatRoom();
	}
	
	// 채팅방 등록
	public int registerChatRoom(Room room) {
		return chatStore.insertChatRoom(room);
	}

//	======= 채팅 메시지 =======
	// 채팅 내역 저장
	public int registerChat(Chat chat) {
		return chatStore.insertChat(chat);
	}

	// 채팅 내역 가져오기
	public ArrayList<Chat> printChat(int roomNumber) {
		return chatStore.selectChat(roomNumber);
	}
}
