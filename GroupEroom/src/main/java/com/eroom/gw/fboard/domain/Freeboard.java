package com.eroom.gw.fboard.domain;

import java.sql.Date;

public class Freeboard {

	private int fBoardNo;
	private int memberId;
	private String fWriter;
	private String fBullet;
	private String fBoardTitle;
	private String fBoardContents;
	private Date enrollDate;
	private int hits;
	private String fStatus;

	public Freeboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getfBoardNo() {
		return fBoardNo;
	}

	public void setfBoardNo(int fBoardNo) {
		this.fBoardNo = fBoardNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getfWriter() {
		return fWriter;
	}

	public void setfWriter(String fWriter) {
		this.fWriter = fWriter;
	}

	public String getfBullet() {
		return fBullet;
	}

	public void setfBullet(String fBullet) {
		this.fBullet = fBullet;
	}

	public String getfBoardTitle() {
		return fBoardTitle;
	}

	public void setfBoardTitle(String fBoardTitle) {
		this.fBoardTitle = fBoardTitle;
	}

	public String getfBoardContents() {
		return fBoardContents;
	}

	public void setfBoardContents(String fBoardContents) {
		this.fBoardContents = fBoardContents;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getfStatus() {
		return fStatus;
	}

	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}

	@Override
	public String toString() {
		return "Freeboard [fBoardNo=" + fBoardNo + ", memberId=" + memberId + ", fWriter=" + fWriter + ", fBullet="
				+ fBullet + ", fBoardTitle=" + fBoardTitle + ", fBoardContents=" + fBoardContents + ", enrollDate="
				+ enrollDate + ", hits=" + hits + ", fStatus=" + fStatus + "]";
	}

	
}
