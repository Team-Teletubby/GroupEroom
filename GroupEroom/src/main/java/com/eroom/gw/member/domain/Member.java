package com.eroom.gw.member.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

	public Member(int memberId,String memberPwd) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	
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
	private String profileModify;
	private String role;
}