package com.eroom.gw.member.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
	private long bankAccount;
	private Date regDate;
	private String quitYn;
	private Date quitDate;
	private String role;
	private String originalFileName;
	private String renameFileName;
	private String status;
	
	public Member() {
			
	}

	public Member(int memberId,String memberPwd) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}

	public Member(int memberId, String memberDept, String memberJob, String memberName, String memberPwd,
			String memberRrn, String memberPhone, String memberEmail, String memberAddr, String bank, long bankAccount,
			Date regDate, String quitYn, Date quitDate, String role, String originalFileName, String renameFileName, String status) {
		super();
		this.memberId = memberId;
		this.memberDept = memberDept;
		this.memberJob = memberJob;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
		this.memberRrn = memberRrn;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
		this.bank = bank;
		this.bankAccount = bankAccount;
		this.regDate = regDate;
		this.quitYn = quitYn;
		this.quitDate = quitDate;
		this.role = role;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.status = status;
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

	public long getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenameFileName() {
		return renameFileName;
	}

	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberDept=" + memberDept + ", memberJob=" + memberJob
				+ ", memberName=" + memberName + ", memberPwd=" + memberPwd + ", memberRrn=" + memberRrn
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberAddr=" + memberAddr
				+ ", bank=" + bank + ", bankAccount=" + bankAccount + ", regDate=" + regDate + ", quitYn=" + quitYn
				+ ", quitDate=" + quitDate + ", role=" + role + ", originalFileName=" + originalFileName
				+ ", renameFileName=" + renameFileName + ", status=" + status + "]";
	}

	

	
}
