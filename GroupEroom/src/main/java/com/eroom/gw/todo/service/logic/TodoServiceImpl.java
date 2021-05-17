package com.eroom.gw.todo.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.todo.domain.Todo;
import com.eroom.gw.todo.service.TodoService;
import com.eroom.gw.todo.store.TodoStore;
@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoStore tdStore;
	
	@Override
	public ArrayList<Todo> selelctAllTodo(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerTodo(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyTodo(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeTodo(int todoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyState(int todoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
