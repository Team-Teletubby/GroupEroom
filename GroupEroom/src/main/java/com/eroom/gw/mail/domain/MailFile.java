package com.eroom.gw.mail.domain;

import java.sql.Timestamp;

public class MailFile {
	
	private int fileNo;
	private String originalFilename;
	private String renameFilename;
	private String filePath;
	private int fileSize;
	private Timestamp uploadDate;
	private int mailNo;
	
	public MailFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MailFile(int fileNo, String originalFilename, String renameFilename, String filePath, int fileSize,
			Timestamp uploadDate, int mailNo) {
		super();
		this.fileNo = fileNo;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.mailNo = mailNo;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Timestamp uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}

	@Override
	public String toString() {
		return "MailFile [fileNo=" + fileNo + ", originalFilename=" + originalFilename + ", renameFilename="
				+ renameFilename + ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate
				+ ", mailNo=" + mailNo + "]";
	}
	
	

}
