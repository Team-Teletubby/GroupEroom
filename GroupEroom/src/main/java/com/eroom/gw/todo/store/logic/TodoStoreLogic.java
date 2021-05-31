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
	public ArrayList<Todo> selelctAllTodo(int memberId) {
		return (ArrayList)sqlSession.selectList("todoMapper.selectAllTodo", memberId);
	}

	@Override
	public int insertTodo(Todo todo) {
		return sqlSession.insert("todoMapper.insertTodo", todo);
	}

	@Override
	public int updateTodo(Todo todo) {
		return sqlSession.update("todoMapper.updateTodo",todo);
	}

	@Override
	public int deleteTodo(int todoNo) {
		return sqlSession.delete("todoMapper.deleteTodo", todoNo);
	}

	@Override
	public int updateTodoState(int todoNo) {
		return sqlSession.update("todoMapper.updateState", todoNo);
	}

}
