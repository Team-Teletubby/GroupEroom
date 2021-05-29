package com.eroom.gw.todo.service;

import java.util.ArrayList;

import com.eroom.gw.todo.domain.Todo;

public interface TodoService {
	
	public ArrayList<Todo> selelctAllTodo(int memberId);
	public int registerTodo(Todo todo);
	public int modifyTodo(Todo todo);
	public int modifyState(int todoNo);
	public int removeTodo(int todoNo);

}
