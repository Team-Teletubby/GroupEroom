package com.eroom.gw.todo.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.todo.domain.Todo;
import com.eroom.gw.todo.service.TodoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

@Controller
public class TodoController {

	@Autowired
	private TodoService tdService;
	
	// 내 할 일 전체 출력
	
	@RequestMapping(value="todoList.do")
	public String todoListView() {
		return "todo/todoList";
	}
	
	
	@RequestMapping(value="todoListView.do")
	public void getTodoList(HttpSession session,HttpServletResponse response) throws Exception {
		Member LoginUser = (Member)session.getAttribute("LoginUser");
		int memberId = LoginUser.getMemberId();
		ArrayList<Todo> todoList = tdService.selelctAllTodo(memberId);
		if(!todoList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create(); // 날짜 포맷 변경!
			gson.toJson(todoList, response.getWriter());
		}else {
			System.out.println("데이터없음");
		}
	}
	
	// 내 할 일 등록
	@ResponseBody
	@RequestMapping(value="todoRegister.do", method=RequestMethod.POST)
	public String todoRegister(@ModelAttribute Todo todo, HttpSession session) {
		Member LoginUser = (Member)session.getAttribute("LoginUser");
		todo.setMemberId(LoginUser.getMemberId());
		int result = tdService.registerTodo(todo);
		if(result >0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 내 할 일 수정
	public ModelAndView todoModify(ModelAndView mv, @ModelAttribute Todo todo) {
		return mv;
	}
	
	// 할 일 상태 업데이트
	public ModelAndView todoModifyState(ModelAndView mv, @RequestParam("")int todoNo) {
		return mv;
	}
	
	// 내 할 일 삭제
	public String todoRemove(Model model, @RequestParam("") int todoNo) {
		return null;
		
	}
}
