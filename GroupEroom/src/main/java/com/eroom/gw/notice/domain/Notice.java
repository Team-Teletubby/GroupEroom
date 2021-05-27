package com.eroom.gw.notice.domain;

import java.sql.Date;

public class Notice {

	
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContents;
	private String noticeFile;
	private Date enrollDate;
	private int hits;
	private String originalFileName;
	private String renameFileName;
	
	public Notice() {}

	public Notice(int noticeNo, String noticeTitle, String noticeWriter, String noticeContents, String noticeFile,
			Date enrollDate, int hits, String originalFileName, String renameFileName) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContents = noticeContents;
		this.noticeFile = noticeFile;
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

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeContents() {
		return noticeContents;
	}

	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}

	public String getNoticeFile() {
		return noticeFile;
	}

	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
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
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeContents=" + noticeContents + ", noticeFile=" + noticeFile + ", enrollDate=" + enrollDate
				+ ", hits=" + hits + ", originalFileName=" + originalFileName + ", renameFileName=" + renameFileName
				+ "]";
	}

	
	}



