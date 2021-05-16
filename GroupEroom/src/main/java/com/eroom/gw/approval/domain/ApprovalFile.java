package com.eroom.gw.approval.domain;

import java.sql.Date;

// 전자결재 파일
public class ApprovalFile {

	// 멤버변수
	private int approvalFileNo;
	private String approvalFileName;
	private String approvalFilePath;
	private int approvalFileSize;
	private Date approvalUploadTime;
	private int approvalNo;
	
	// 생성자
	public ApprovalFile() {
		super();
		
	}
	public ApprovalFile(int approvalFileNo, String approvalFileName, String approvalFilePath, int approvalFileSize,
			Date approvalUploadTime, int approvalNo) {
		super();
		this.approvalFileNo = approvalFileNo;
		this.approvalFileName = approvalFileName;
		this.approvalFilePath = approvalFilePath;
		this.approvalFileSize = approvalFileSize;
		this.approvalUploadTime = approvalUploadTime;
		this.approvalNo = approvalNo;
	}
	
	// getter/setter
	public int getApprovalFileNo() {
		return approvalFileNo;
	}
	public void setApprovalFileNo(int approvalFileNo) {
		this.approvalFileNo = approvalFileNo;
	}
	public String getApprovalFileName() {
		return approvalFileName;
	}
	public void setApprovalFileName(String approvalFileName) {
		this.approvalFileName = approvalFileName;
	}
	public String getApprovalFilePath() {
		return approvalFilePath;
	}
	public void setApprovalFilePath(String approvalFilePath) {
		this.approvalFilePath = approvalFilePath;
	}
	public int getApprovalFileSize() {
		return approvalFileSize;
	}
	public void setApprovalFileSize(int approvalFileSize) {
		this.approvalFileSize = approvalFileSize;
	}
	public Date getApprovalUploadTime() {
		return approvalUploadTime;
	}
	public void setApprovalUploadTime(Date approvalUploadTime) {
		this.approvalUploadTime = approvalUploadTime;
	}
	public int getApprovalNo() {
		return approvalNo;
	}
	public void setApprovalNo(int approvalNo) {
		this.approvalNo = approvalNo;
	}
	
	// toString
	@Override
	public String toString() {
		return "ApprovalFile [approvalFileNo=" + approvalFileNo + ", approvalFileName=" + approvalFileName
				+ ", approvalFilePath=" + approvalFilePath + ", approvalFileSize=" + approvalFileSize
				+ ", approvalUploadTime=" + approvalUploadTime + ", approvalNo=" + approvalNo + "]";
	}
	
}
