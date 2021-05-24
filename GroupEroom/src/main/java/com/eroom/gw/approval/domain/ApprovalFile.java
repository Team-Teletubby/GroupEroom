package com.eroom.gw.approval.domain;

import java.sql.Date;

// 전자결재 파일
public class ApprovalFile {

	// 멤버변수
	private int approvalFileNo;
	private String originalFileName;
	private String reNameFileName;
	private String approvalFilePath;
	private long approvalFileSize;
	private Date approvalUploadTime;
	private int approvalNo;
	
	// 생성자
	public ApprovalFile() {
		super();
		
	}
	public ApprovalFile(int approvalFileNo, String originalFileName, String reNameFileName, String approvalFilePath, long approvalFileSize,
			Date approvalUploadTime, int approvalNo) {
		super();
		this.approvalFileNo = approvalFileNo;
		this.originalFileName = originalFileName;
		this.reNameFileName = reNameFileName;
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
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getReNameFileName() {
		return reNameFileName;
	}
	public void setReNameFileName(String reNameFileName) {
		this.reNameFileName = reNameFileName;
	}
	public String getApprovalFilePath() {
		return approvalFilePath;
	}
	public void setApprovalFilePath(String approvalFilePath) {
		this.approvalFilePath = approvalFilePath;
	}
	public long getApprovalFileSize() {
		return approvalFileSize;
	}
	public void setApprovalFileSize(long approvalFileSize) {
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
		return "ApprovalFile [approvalFileNo=" + approvalFileNo + ", originalFileName=" + originalFileName
				+ ", reNameFileName=" + reNameFileName + ", approvalFilePath=" + approvalFilePath + ", approvalFileSize=" + approvalFileSize
				+ ", approvalUploadTime=" + approvalUploadTime + ", approvalNo=" + approvalNo + "]";
	}
	
}
