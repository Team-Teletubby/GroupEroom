package com.eroom.gw.cboard.domain;

import java.sql.Date;

public class Reply {
	
	private int replyNo;
	private String replyContent;
	private Date rCreateDate;
	private int cBoardNo;
	private int memberId;
	private String memberName;
	
	public Reply() {}

	public Reply(int replyNo, String replyContent, Date rCreateDate, int cBoardNo, int memberId, String memberName) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.rCreateDate = rCreateDate;
		this.cBoardNo = cBoardNo;
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getrCreateDate() {
		return rCreateDate;
	}

	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", rCreateDate=" + rCreateDate
				+ ", cBoardNo=" + cBoardNo + ", memberId=" + memberId + ", memberName=" + memberName + "]";
	}

	
	
}
