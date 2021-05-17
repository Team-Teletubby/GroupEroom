package com.eroom.gw.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eroom.gw.todo.domain.Todo;
import com.eroom.gw.todo.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService tdService;
	
	// 내 할 일 전체 출력
	public ModelAndView todoListView(ModelAndView mv,@RequestParam("")int memberId) {
		return mv;
	}
	
	// 내 할 일 등록
	public ModelAndView todoRegister(ModelAndView mv, @ModelAttribute Todo todo) {
		return mv;
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
