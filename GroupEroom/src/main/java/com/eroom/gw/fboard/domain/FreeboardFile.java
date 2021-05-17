package com.eroom.gw.fboard.domain;

import java.sql.Timestamp;

public class FreeboardFile {
	
	private int fileNo;
	private String originalFilename;
	private String renameFilename;
	private String filePath;
	private int fileSize;
	private Timestamp uploadDate;
	private int fBoardNo;
	private int memberId;
	
	public FreeboardFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FreeboardFile(int fileNo, String originalFilename, String renameFilename, String filePath, int fileSize,
			Timestamp uploadDate, int fBoardNo, int memberId) {
		super();
		this.fileNo = fileNo;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.fBoardNo = fBoardNo;
		this.memberId = memberId;
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
	
	@Override
	public String toString() {
		return "FreeboardFile [fileNo=" + fileNo + ", originalFilename=" + originalFilename + ", renameFilename="
				+ renameFilename + ", filePath=" + filePath + ", fileSize=" + fileSize + ", uploadDate=" + uploadDate
				+ ", fBoardNo=" + fBoardNo + ", memberId=" + memberId + "]";
	}
	
	
	
	
}
