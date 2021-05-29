package com.eroom.gw.todo.store;

import java.util.ArrayList;

import com.eroom.gw.todo.domain.Todo;

public interface TodoStore {
	
	public ArrayList<Todo> selelctAllTodo(int memberId);
	public int insertTodo(Todo todo);
	public int updateTodo(Todo todo);
	public int updateTodoState(int todoNo);
	public int deleteTodo(int todoNo);
}
