package com.eroom.gw.mail.domain;

import java.sql.Date;

public class MailFile {
	
	private int FileNo;
	private String originalFilename;
	private String renameFilename;
	private String filePath;
	private long fileSize;
	private Date uploadDate;
	private int mailNo;
	private int memberId;
	public MailFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFileNo() {
		return FileNo;
	}
	public void setFileNo(int fileNo) {
		FileNo = fileNo;
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
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "MailFile [FileNo=" + FileNo + ", originalFilename=" + originalFilename + ", renameFilename="
				+ renameFilename + ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate
				+ ", mailNo=" + mailNo + ", memberId=" + memberId + "]";
	}
	
	

}
