package com.eroom.gw.chatting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.chatting.domain.Chat;
import com.eroom.gw.chatting.domain.Room;
import com.eroom.gw.chatting.service.ChatService;
import com.eroom.gw.member.domain.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Controller
public class MainController {
	
	@Autowired
	private ChatService chatService;
	
	ArrayList<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	
	@RequestMapping("/chat.do")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/chatting/chat");
		return mv;
	}
	
	/**
	 * 방 페이지
	 * @return
	 */
	@RequestMapping("/room.do")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/chatting/room");
		return mv;
	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	@RequestMapping("/createRoom.do")
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			roomList = chatService.printChatRoom();
			int plusNumber = roomList.size(); 
			Room room = new Room();
			room.setRoomNumber(++plusNumber);
			room.setRoomName(roomName);
			int result = chatService.registerChatRoom(room);
			if(result > 0) {
				roomList = chatService.printChatRoom();
			}
		}
		return roomList;
	}
	
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getRoom.do")
	public List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		System.out.println("getRoom 메소드");
		roomList = chatService.printChatRoom();
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	@RequestMapping("/moveChating.do")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params, HttpServletRequest request) {
		System.out.println("moveChating 실행됨");
		ModelAndView mv = new ModelAndView();
		HttpSession session1 = request.getSession();
		Member member = (Member)session1.getAttribute("LoginUser");
		
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		System.out.println("무브채팅에서 roomNumber: " + roomNumber);
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			System.out.println("여기 들어옴");
			System.out.println("params number :" + params.get("roomNumber") );
			mv.addObject("userName", member.getMemberName());
			mv.addObject("userId", member.getMemberId());
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("/chatting/chat");
		}else {
			mv.setViewName("/chatting/room");
		}
		return mv;
	}
	
	@RequestMapping("/registerChatDate.do")
	public String registerChat(@ModelAttribute Chat chat) {
		int result = chatService.registerChat(chat);
		
		return "";
	}
	
	@RequestMapping("/chatLogDate.do")
	public void chatLogDate(@RequestParam("roomNumber")int roomNumber, HttpServletResponse response) throws JsonIOException, IOException {
		
		ArrayList<Chat> chatList = chatService.printChat(roomNumber);
		if(!chatList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			gson.toJson(chatList, response.getWriter());
		}else {
			System.out.println("채팅 내역 리스트 가져오기 오류");
		}
	}
}