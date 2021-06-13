package com.eroom.gw.cboard.domain;

import java.sql.Date;

public class CBoard {

	private int cBoardNo;
	private int memberId;
	private String memberName;
	private String cBoardTitle;
	private String cBoardContents;
	private Date enrollDate;
	private int hits;
	private String originalFileName;
	private String renameFileName;
	private String memberImage;
	private String memberDept;
	private String memberJob;
	
	public CBoard() {}

	public int getcBoardNo() {
		return cBoardNo;
	}

	public void setcBoardNo(int cBoardNo) {
		this.cBoardNo = cBoardNo;
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

	public String getcBoardTitle() {
		return cBoardTitle;
	}

	public void setcBoardTitle(String cBoardTitle) {
		this.cBoardTitle = cBoardTitle;
	}

	public String getcBoardContents() {
		return cBoardContents;
	}

	public void setcBoardContents(String cBoardContents) {
		this.cBoardContents = cBoardContents;
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

	public String getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(String memberImage) {
		this.memberImage = memberImage;
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

	@Override
	public String toString() {
		return "CBoard [cBoardNo=" + cBoardNo + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", cBoardTitle=" + cBoardTitle + ", cBoardContents=" + cBoardContents + ", enrollDate=" + enrollDate
				+ ", hits=" + hits + ", originalFileName=" + originalFileName + ", renameFileName=" + renameFileName
				+ ", memberImage=" + memberImage + ", memberDept=" + memberDept + ", memberJob=" + memberJob + "]";
	}

	
	
	
	
}
