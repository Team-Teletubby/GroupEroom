package com.eroom.gw.todo.domain;

public class Todo {
	
	private int todoNo;
	private int memberId;
	private int todoPriority;
	private String todoContents;
	private String todoState;
	
	public Todo() {}

	public int getTodoNo() {
		return todoNo;
	}

	public void setTodoNo(int todoNo) {
		this.todoNo = todoNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getTodoPriority() {
		return todoPriority;
	}

	public void setTodoPriority(int todoPriority) {
		this.todoPriority = todoPriority;
	}

	public String getTodoContents() {
		return todoContents;
	}

	public void setTodoContents(String todoContents) {
		this.todoContents = todoContents;
	}

	public String getTodoState() {
		return todoState;
	}

	public void setTodoState(String todoState) {
		this.todoState = todoState;
	}

	@Override
	public String toString() {
		return "Todo [todoNo=" + todoNo + ", memberId=" + memberId + ", todoPriority=" + todoPriority
				+ ", todoContents=" + todoContents + ", todoState=" + todoState + "]";
	}
	
	

}
