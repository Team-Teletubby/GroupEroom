package com.eroom.gw.fboard.domain;

import java.sql.Date;

public class Freeboard {
	
	private int fBoardNo;
	private int memberId;
	private String fBoardTilte;
	private String fBoardContents;
	private Date enrollDate;
	private int hits;
	
	public Freeboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Freeboard(int fBoardNo, int memberId, String fBoardTilte, String fBoardContents, Date enrollDate, int hits) {
		super();
		this.fBoardNo = fBoardNo;
		this.memberId = memberId;
		this.fBoardTilte = fBoardTilte;
		this.fBoardContents = fBoardContents;
		this.enrollDate = enrollDate;
		this.hits = hits;
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
	public String getfBoardTilte() {
		return fBoardTilte;
	}
	public void setfBoardTilte(String fBoardTilte) {
		this.fBoardTilte = fBoardTilte;
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
	
	@Override
	public String toString() {
		return "Freeboard [fBoardNo=" + fBoardNo + ", memberId=" + memberId + ", fBoardTilte=" + fBoardTilte
				+ ", fBoardContents=" + fBoardContents + ", enrollDate=" + enrollDate + ", hits=" + hits + "]";
	}
	
	

}
