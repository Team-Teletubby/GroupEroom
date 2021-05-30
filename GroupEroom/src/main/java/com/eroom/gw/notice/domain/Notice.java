package com.eroom.gw.notice.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Notice {

	
	private int noticeNo;
	private int memberId;
	private String noticeTitle;
	private String memberName;
	private String noticeContents;
	private Date enrollDate;
	private int hits;
	private String originalFileName;
	private String renameFileName;

	public Notice() {}

	public Notice(int noticeNo, int memberId, String noticeTitle, String memberName, String noticeContents,
			Date enrollDate, int hits, String originalFileName, String renameFileName) {
		super();
		this.noticeNo = noticeNo;
		this.memberId = memberId;
		this.noticeTitle = noticeTitle;
		this.memberName = memberName;
		this.noticeContents = noticeContents;
		this.enrollDate = enrollDate;
		this.hits = hits;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
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

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", memberId=" + memberId + ", noticeTitle=" + noticeTitle
				+ ", memberName=" + memberName + ", noticeContents=" + noticeContents + ", enrollDate=" + enrollDate
				+ ", hits=" + hits + ", originalFileName=" + originalFileName + ", renameFileName=" + renameFileName
				+ "]";
	}
	
	
}