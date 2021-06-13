package com.eroom.gw.cboard.domain;

import java.sql.Timestamp;

public class Reply {
	
	private int replyNo;
	private String replyContent;
	private Timestamp rCreateDate;
	private int cBoardNo;
	private int memberId;
	private String memberName;
	private String memberImage;
	private int family;
	private int step;
	private int count;
	
	public Reply() {}

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

	public Timestamp getrCreateDate() {
		return rCreateDate;
	}

	public void setrCreateDate(Timestamp rCreateDate) {
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

	public String getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(String memberImage) {
		this.memberImage = memberImage;
	}

	public int getFamily() {
		return family;
	}

	public void setFamily(int family) {
		this.family = family;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", rCreateDate=" + rCreateDate
				+ ", cBoardNo=" + cBoardNo + ", memberId=" + memberId + ", memberName=" + memberName + ", memberImage="
				+ memberImage + ", family=" + family + ", step=" + step + ", count=" + count + "]";
	}

	
	
}