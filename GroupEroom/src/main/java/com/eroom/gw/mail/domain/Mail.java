package com.eroom.gw.mail.domain;

import java.sql.Date;

public class Mail {
	
	private int mailNo;
	private int receiverId;
	private int senderId;
	private int ccId;
	private String memberName;
	private String mailTitle;
	private String mailContents;
	private Date sentDate;
	private Date reddDate;
	private int readCount;
	private String trashYn;
	
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mail(int mailNo, int receiverId, int senderId, int ccId, String memberName, String mailTitle,
			String mailContents, Date sentDate, Date reddDate, int readCount, String trashYn) {
		super();
		this.mailNo = mailNo;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.ccId = ccId;
		this.memberName = memberName;
		this.mailTitle = mailTitle;
		this.mailContents = mailContents;
		this.sentDate = sentDate;
		this.reddDate = reddDate;
		this.readCount = readCount;
		this.trashYn = trashYn;
	}

	public int getMailNo() {
		return mailNo;
	}
	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getCcId() {
		return ccId;
	}
	public void setCcId(int ccId) {
		this.ccId = ccId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMailTitle() {
		return mailTitle;
	}
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	public String getMailContents() {
		return mailContents;
	}
	public void setMailContents(String mailContents) {
		this.mailContents = mailContents;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public Date getReddDate() {
		return reddDate;
	}
	public void setReddDate(Date reddDate) {
		this.reddDate = reddDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public String getTrashYn() {
		return trashYn;
	}

	public void setTrashYn(String trashYn) {
		this.trashYn = trashYn;
	}

	@Override
	public String toString() {
		return "Mail [mailNo=" + mailNo + ", receiverId=" + receiverId + ", senderId=" + senderId + ", ccId=" + ccId
				+ ", memberName=" + memberName + ", mailTitle=" + mailTitle + ", mailContents=" + mailContents
				+ ", sentDate=" + sentDate + ", reddDate=" + reddDate + ", readCount=" + readCount + ", trashYn="
				+ trashYn + "]";
	}
	
	

}
