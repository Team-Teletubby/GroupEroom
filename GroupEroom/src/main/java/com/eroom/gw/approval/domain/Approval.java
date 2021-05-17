package com.eroom.gw.approval.domain;

import java.sql.Date;

// 전자결재
public class Approval {
	
	// 멤버변수
	private int approvalNo;
	private int memberId;
	private String approvalType;
	private String approvalTitle;
	private String approvalContents;
	private int approvalCC;
	private Date approvalDate;
	private String approvalState;
	private int approvalFirst;
	private Date approvalFirstDate;
	private int approvalSecond;
	private Date approvalScondDate;
	private ApprovalFile file;
	private ApprovalReply reply;
	
	// 생성자
	public Approval() {
		super();
	}


	// getter/setter
	public int getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(int approvalNo) {
		this.approvalNo = approvalNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getApprovalTitle() {
		return approvalTitle;
	}

	public void setApprovalTitle(String approvalTitle) {
		this.approvalTitle = approvalTitle;
	}

	public String getApprovalContents() {
		return approvalContents;
	}

	public void setApprovalContents(String approvalContents) {
		this.approvalContents = approvalContents;
	}

	public int getApprovalCC() {
		return approvalCC;
	}

	public void setApprovalCC(int approvalCC) {
		this.approvalCC = approvalCC;
	}

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprovalState() {
		return approvalState;
	}

	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}

	public int getApprovalFirst() {
		return approvalFirst;
	}

	public void setApprovalFirst(int approvalFirst) {
		this.approvalFirst = approvalFirst;
	}

	public Date getApprovalFirstDate() {
		return approvalFirstDate;
	}

	public void setApprovalFirstDate(Date approvalFirstDate) {
		this.approvalFirstDate = approvalFirstDate;
	}

	public int getApprovalSecond() {
		return approvalSecond;
	}

	public void setApprovalSecond(int approvalSecond) {
		this.approvalSecond = approvalSecond;
	}

	public Date getApprovalScondDate() {
		return approvalScondDate;
	}

	public void setApprovalScondDate(Date approvalScondDate) {
		this.approvalScondDate = approvalScondDate;
	}

	public ApprovalFile getFile() {
		return file;
	}

	public void setFile(ApprovalFile file) {
		this.file = file;
	}

	public ApprovalReply getReply() {
		return reply;
	}

	public void setReply(ApprovalReply reply) {
		this.reply = reply;
	}

	// toString
	@Override
	public String toString() {
		return "Approval [approvalNo=" + approvalNo + ", memberId=" + memberId + ", approvalType=" + approvalType
				+ ", approvalTitle=" + approvalTitle + ", approvalContents=" + approvalContents + ", approvalCC="
				+ approvalCC + ", approvalDate=" + approvalDate + ", approvalState=" + approvalState
				+ ", approvalFirst=" + approvalFirst + ", approvalFirstDate=" + approvalFirstDate + ", approvalSecond="
				+ approvalSecond + ", approvalScondDate=" + approvalScondDate + ", file=" + file + ", reply=" + reply
				+ "]";
	}
	
}
