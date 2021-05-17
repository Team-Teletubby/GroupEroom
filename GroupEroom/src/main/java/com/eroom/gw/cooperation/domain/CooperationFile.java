package com.eroom.gw.cooperation.domain;

import java.sql.Timestamp;

public class CooperationFile {

	private int fileNo;
	private String originalFilename;
	private String renameFilename;
	private String filePath;
	private int fileSize;
	private Timestamp uploadDate;
	private int coNo;
	private int memberId;
	
	public CooperationFile(int fileNo, String originalFilename, String renameFilename, String filePath, int fileSize,
			Timestamp uploadDate, int coNo, int memberId) {
		super();
		this.fileNo = fileNo;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.coNo = coNo;
		this.memberId = memberId;
	}
	
	public CooperationFile() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "CooperationFile [fileNo=" + fileNo + ", originalFilename=" + originalFilename + ", renameFilename="
				+ renameFilename + ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate
				+ ", coNo=" + coNo + ", memberId=" + memberId + "]";
	}
	

	
	
}
