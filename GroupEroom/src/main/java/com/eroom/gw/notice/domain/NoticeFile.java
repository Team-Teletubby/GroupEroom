package com.eroom.gw.notice.domain;

import java.sql.Timestamp;

public class NoticeFile {

	private int fileNo;
	private String fileName;
	private String filePath;
	private String fileSize;
	private Timestamp uploadTime;
	
	public NoticeFile() {}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "NoticeFile [fileNo=" + fileNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", uploadTime=" + uploadTime + "]";
	} 
	
	
}
