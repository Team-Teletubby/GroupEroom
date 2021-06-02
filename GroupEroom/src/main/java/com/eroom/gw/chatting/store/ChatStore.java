package com.eroom.gw.chatting.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.chatting.domain.Chat;
import com.eroom.gw.chatting.domain.Room;

@Repository
public class ChatStore {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
//	======= 채팅방 =======
	// 채팅방 리스트
	public ArrayList<Room> selectChatRoom() {
		return (ArrayList)sqlSession.selectList("chatMapper.selectChatRoom");
	}
	
	// 채팅방 등록
	public int insertChatRoom(Room room) {
		return sqlSession.insert("chatMapper.insertChatRoom", room);
	}

//	======= 채팅 메시지 =======
	// 채팅 내역 가져오기
	public ArrayList<Chat> selectChat(int roomNumber) {
		return (ArrayList)sqlSession.selectList("chatMapper.selectChat", roomNumber);
	}	
	
	// 채팅 내역 저장
	public int insertChat(Chat chat) {
		return sqlSession.insert("chatMapper.insertChat", chat);
	}

}
