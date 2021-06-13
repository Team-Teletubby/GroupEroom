package com.eroom.gw.approval.domain;

import java.sql.Date;
import java.sql.Timestamp;

// 전자결재 댓글
public class ApprovalReply {

	// 멤버변수
	private int cmtNo;
	private String cmtContents;
	private Timestamp enrollDate;
	private int approvalNo;
	private int memberId;
	private String memberJob;
	private String memberName;
	
	// 생성자
	public ApprovalReply() {
		super();
	}
	
	public ApprovalReply(int cmtNo, String cmtContents, Timestamp enrollDate, int approvalNo, int memberId, String memberName, String memberJob) {
		super();
		this.cmtNo = cmtNo;
		this.cmtContents = cmtContents;
		this.enrollDate = enrollDate;
		this.approvalNo = approvalNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberJob = memberJob;
	}
	
	// getter/setter
	public int getCmtNo() {
		return cmtNo;
	}
	public void setCmtNo(int cmtNo) {
		this.cmtNo = cmtNo;
	}
	public String getCmtContents() {
		return cmtContents;
	}
	public void setCmtContents(String cmtContents) {
		this.cmtContents = cmtContents;
	}
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
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

	@Override
	public String toString() {
		return "ApprovalReply [cmtNo=" + cmtNo + ", cmtContents=" + cmtContents + ", enrollDate=" + enrollDate
				+ ", approvalNo=" + approvalNo + ", memberId=" + memberId + ", memberJob=" + memberJob + ", memberName="
				+ memberName + "]";
	}


}
