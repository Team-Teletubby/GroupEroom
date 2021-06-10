package com.eroom.gw.cooperation.domain;

import java.sql.Date;

public class Cooperation {
	
	private int coNo;
	private int memberId;
	private String memberName;
	private String coContents;
	private String originalFilename;
	private String renameFilename;
	private Date enrollDate;
	private int roomNo;
	private String roomName;
	
	public Cooperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cooperation(int coNo, int memberId, String memberName, String coContents, String originalFilename,
			String renameFilename, Date enrollDate, int roomNo, String roomName) {
		super();
		this.coNo = coNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.coContents = coContents;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.enrollDate = enrollDate;
		this.roomNo = roomNo;
		this.roomName = roomName;
	}

	public int getCoNo() {
		return coNo;
	}

	public void setCoNo(int coNo) {
		this.coNo = coNo;
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

	public String getCoContents() {
		return coContents;
	}

	public void setCoContents(String coContents) {
		this.coContents = coContents;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getRenameFilename() {
		return renameFilename;
	}

	public void setRenameFilename(String renameFilename) {
		this.renameFilename = renameFilename;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String toString() {
		return "Cooperation [coNo=" + coNo + ", memberId=" + memberId + ", memberName=" + memberName + ", coContents="
				+ coContents + ", originalFilename=" + originalFilename + ", renameFilename=" + renameFilename
				+ ", enrollDate=" + enrollDate + ", roomNo=" + roomNo + ", roomName=" + roomName + "]";
	}
	
	
	
}
