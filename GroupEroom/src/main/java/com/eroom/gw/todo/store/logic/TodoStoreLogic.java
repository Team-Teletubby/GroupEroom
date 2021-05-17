package com.eroom.gw.todo.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.todo.domain.Todo;
import com.eroom.gw.todo.store.TodoStore;

@Repository
public class TodoStoreLogic implements TodoStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public ArrayList<Todo> selelctAllTodo(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTodo(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTodo(int todoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTodoState(int todoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
