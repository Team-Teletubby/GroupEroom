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
	private String approvalCC;
	private Date approvalDate;
	private String approvalState;
	private int approvalFirstId;
	private Date approvalFirstDate;
	private String approvalFirstCheck;
	private String approvalFirstName;
	private int approvalSecondId;
	private Date approvalScondDate;
	private String approvalSecondCheck;
	private String approvalSecondName;
	private ApprovalFile file;
	private ApprovalReply reply;
	
	// 생성자
	public Approval() {
		super();
	}

	// getter, setter
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

	public String getApprovalCC() {
		return approvalCC;
	}

	public void setApprovalCC(String approvalCC) {
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

	public int getApprovalFirstId() {
		return approvalFirstId;
	}

	public void setApprovalFirstId(int approvalFirstId) {
		this.approvalFirstId = approvalFirstId;
	}

	public Date getApprovalFirstDate() {
		return approvalFirstDate;
	}

	public void setApprovalFirstDate(Date approvalFirstDate) {
		this.approvalFirstDate = approvalFirstDate;
	}

	public String getApprovalFirstCheck() {
		return approvalFirstCheck;
	}

	public void setApprovalFirstCheck(String approvalFirstCheck) {
		this.approvalFirstCheck = approvalFirstCheck;
	}

	public int getApprovalSecondId() {
		return approvalSecondId;
	}

	public void setApprovalSecondId(int approvalSecondId) {
		this.approvalSecondId = approvalSecondId;
	}

	public Date getApprovalScondDate() {
		return approvalScondDate;
	}

	public void setApprovalScondDate(Date approvalScondDate) {
		this.approvalScondDate = approvalScondDate;
	}

	public String getApprovalSecondCheck() {
		return approvalSecondCheck;
	}

	public void setApprovalSecondCheck(String approvalSecondCheck) {
		this.approvalSecondCheck = approvalSecondCheck;
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

	public String getApprovalFirstName() {
		return approvalFirstName;
	}

	public void setApprovalFirstName(String approvalFirstName) {
		this.approvalFirstName = approvalFirstName;
	}

	public String getApprovalSecondName() {
		return approvalSecondName;
	}

	public void setApprovalSecondName(String approvalSecondName) {
		this.approvalSecondName = approvalSecondName;
	}

	// toString
	@Override
	public String toString() {
		return "Approval [approvalNo=" + approvalNo + ", memberId=" + memberId + ", approvalType=" + approvalType
				+ ", approvalTitle=" + approvalTitle + ", approvalContents=" + approvalContents + ", approvalCC="
				+ approvalCC + ", approvalDate=" + approvalDate + ", approvalState=" + approvalState
				+ ", approvalFirstId=" + approvalFirstId + ", approvalFirstDate=" + approvalFirstDate
				+ ", approvalFirstCheck=" + approvalFirstCheck + ", approvalFirstName=" + approvalFirstName
				+ ", approvalSecondId=" + approvalSecondId + ", approvalScondDate=" + approvalScondDate
				+ ", approvalSecondCheck=" + approvalSecondCheck + ", approvalSecondName=" + approvalSecondName
				+ ", file=" + file + ", reply=" + reply + "]";
	}
	
}
