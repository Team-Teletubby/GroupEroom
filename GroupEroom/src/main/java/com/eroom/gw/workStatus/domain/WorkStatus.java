package com.eroom.gw.workStatus.domain;

public class WorkStatus {
	private int memberId; // 사번
	private String memberName; // 이름
	private String memberJob; // 직급
	private String memberDept; // 부서
	private String status; // 상태
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WorkStatus [memberId=" + memberId + ", memberName=" + memberName + ", memberJob=" + memberJob
				+ ", memberDept=" + memberDept + ", status=" + status + "]";
	}
}
