package com.eroom.gw.approval.domain;

import java.sql.Date;

// 전자결재
public class Approval {
	
	// 멤버변수
	private int approvalNo;
	private int memberId;
	private String memberName;
	private String memberJob;
	private String memberDept;
	private String approvalType;
	private String approvalTitle;
	private String approvalContents;
	private String approvalCC;
	private Date approvalDate;
	private String approvalState;
	private int approvalFirstId;
	private String approvalFirstName;
	private String approvalFirstJob;
	private String approvalFirstDept;
	private Date approvalFirstDate;
	private String approvalFirstCheck;
	private int approvalSecondId;
	private String approvalSecondName;
	private String approvalSecondJob;
	private String approvalSecondDept;
	private Date approvalScondDate;
	private String approvalSecondCheck;
	private String approvalFileCheck; 
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberJob() {
		return memberJob;
	}

	public void setMemberJob(String memberJob) {
		this.memberJob = memberJob;
	}

	public String getMemberDept() {
		return memberDept;
	}

	public void setMemberDept(String memberDept) {
		this.memberDept = memberDept;
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

	public String getApprovalFirstName() {
		return approvalFirstName;
	}

	public void setApprovalFirstName(String approvalFirstName) {
		this.approvalFirstName = approvalFirstName;
	}

	public String getApprovalFirstJob() {
		return approvalFirstJob;
	}

	public void setApprovalFirstJob(String approvalFirstJob) {
		this.approvalFirstJob = approvalFirstJob;
	}

	public String getApprovalFirstDept() {
		return approvalFirstDept;
	}

	public void setApprovalFirstDept(String approvalFirstDept) {
		this.approvalFirstDept = approvalFirstDept;
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

	public String getApprovalSecondName() {
		return approvalSecondName;
	}

	public void setApprovalSecondName(String approvalSecondName) {
		this.approvalSecondName = approvalSecondName;
	}

	public String getApprovalSecondJob() {
		return approvalSecondJob;
	}

	public void setApprovalSecondJob(String approvalSecondJob) {
		this.approvalSecondJob = approvalSecondJob;
	}

	public String getApprovalSecondDept() {
		return approvalSecondDept;
	}

	public void setApprovalSecondDept(String approvalSecondDept) {
		this.approvalSecondDept = approvalSecondDept;
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

	public String getApprovalFileCheck() {
		return approvalFileCheck;
	}

	public void setApprovalFileCheck(String approvalFileCheck) {
		this.approvalFileCheck = approvalFileCheck;
	}

	@Override
	public String toString() {
		return "Approval [approvalNo=" + approvalNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", memberJob=" + memberJob + ", memberDept=" + memberDept + ", approvalType=" + approvalType
				+ ", approvalTitle=" + approvalTitle + ", approvalContents=" + approvalContents + ", approvalCC="
				+ approvalCC + ", approvalDate=" + approvalDate + ", approvalState=" + approvalState
				+ ", approvalFirstId=" + approvalFirstId + ", approvalFirstName=" + approvalFirstName
				+ ", approvalFirstJob=" + approvalFirstJob + ", approvalFirstDept=" + approvalFirstDept
				+ ", approvalFirstDate=" + approvalFirstDate + ", approvalFirstCheck=" + approvalFirstCheck
				+ ", approvalSecondId=" + approvalSecondId + ", approvalSecondName=" + approvalSecondName
				+ ", approvalSecondJob=" + approvalSecondJob + ", approvalSecondDept=" + approvalSecondDept
				+ ", approvalScondDate=" + approvalScondDate + ", approvalSecondCheck=" + approvalSecondCheck
				+ ", file=" + file + ", reply=" + reply + "approvalFileCheck" + approvalFileCheck + "]";
	}
}
