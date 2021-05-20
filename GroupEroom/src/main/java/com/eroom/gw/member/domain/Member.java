package com.eroom.gw.member.domain;

import java.sql.Date;

public class Member {

	private int memberId; 
	private String memberDept;
	private String memberJob;
	private String memberName;
	private String memberPwd;
	private String memberRrn;
	private String memberPhone;
	private String memberEmail;
	private String memberAddr;
	private String bank;
	private int Account;
	private Date regDate;
	private String quitYn;
	private Date quitDate;
	
	public Member() {}



	public Member(int memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}



	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberDept() {
		return memberDept;
	}

	public void setMemberDept(String memberDept) {
		this.memberDept = memberDept;
	}

	public String getMemberJob() {
		return memberJob;
	}

	public void setMemberJob(String memberJob) {
		this.memberJob = memberJob;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberRrn() {
		return memberRrn;
	}

	public void setMemberRrn(String memberRrn) {
		this.memberRrn = memberRrn;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getAccount() {
		return Account;
	}

	public void setAccount(int account) {
		Account = account;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getQuitYn() {
		return quitYn;
	}

	public void setQuitYn(String quitYn) {
		this.quitYn = quitYn;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberDept=" + memberDept + ", memberJob=" + memberJob
				+ ", memberName=" + memberName + ", memberPwd=" + memberPwd + ", memberRrn=" + memberRrn
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberAddr=" + memberAddr
				+ ", bank=" + bank + ", Account=" + Account + ", regDate=" + regDate + ", quitYn=" + quitYn
				+ ", quitDate=" + quitDate + "]";
	}
	
	
	
	
}
