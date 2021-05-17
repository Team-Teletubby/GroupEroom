package com.eroom.gw.cooperation.domain;

import java.sql.Date;

public class Cooperation {
	
	private int coNo;
	private int memberId;
	private String coTitle;
	private String coContents;
	private String originalFilename;
	private String renameFilename;
	private Date enrollDate;
	
	public Cooperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cooperation(int coNo, int memberId, String coTitle, String coContents, String originalFilename,
			String renameFilename, Date enrollDate) {
		super();
		this.coNo = coNo;
		this.memberId = memberId;
		this.coTitle = coTitle;
		this.coContents = coContents;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.enrollDate = enrollDate;
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
	public String getCoTitle() {
		return coTitle;
	}
	public void setCoTitle(String coTitle) {
		this.coTitle = coTitle;
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
	
	@Override
	public String toString() {
		return "Cooperation [coNo=" + coNo + ", memberId=" + memberId + ", coTitle=" + coTitle + ", coContents="
				+ coContents + ", originalFilename=" + originalFilename + ", renameFilename=" + renameFilename
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	

}
