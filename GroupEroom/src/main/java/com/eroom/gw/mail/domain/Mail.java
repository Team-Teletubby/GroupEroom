package com.eroom.gw.mail.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Mail {
	
	private int mailNo;
	private int receiverId;
	private String receiverName;
	private int senderId;
	private String senderName;
	private int ccId;
	private String ccName;
	private String mailTitle;
	private String mailContents;
	private Timestamp sentDate;
	private Timestamp readDate;
	private int readCount;
	private String trashYn;
	
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Mail(int mailNo, int receiverId, String receiverName, int senderId, String senderName, int ccId,
			String ccName, String mailTitle, String mailContents, Timestamp sentDate, Timestamp readDate, int readCount,
			String trashYn) {
		super();
		this.mailNo = mailNo;
		this.receiverId = receiverId;
		this.receiverName = receiverName;
		this.senderId = senderId;
		this.senderName = senderName;
		this.ccId = ccId;
		this.ccName = ccName;
		this.mailTitle = mailTitle;
		this.mailContents = mailContents;
		this.sentDate = sentDate;
		this.readDate = readDate;
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
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public int getCcId() {
		return ccId;
	}
	public void setCcId(int ccId) {
		this.ccId = ccId;
	}
	public String getCcName() {
		return ccName;
	}
	public void setCcName(String ccName) {
		this.ccName = ccName;
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
	public Timestamp getSentDate() {
		return sentDate;
	}
	public void setSentDate(Timestamp sentDate) {
		this.sentDate = sentDate;
	}
	public Timestamp getReadDate() {
		return readDate;
	}
	public void setReadDate(Timestamp readDate) {
		this.readDate = readDate;
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
		return "Mail [mailNo=" + mailNo + ", receiverId=" + receiverId + ", receiverName=" + receiverName
				+ ", senderId=" + senderId + ", senderName=" + senderName + ", ccId=" + ccId + ", ccName=" + ccName
				+ ", mailTitle=" + mailTitle + ", mailContents=" + mailContents + ", sentDate=" + sentDate
				+ ", readDate=" + readDate + ", readCount=" + readCount + ", trashYn=" + trashYn + "]";
	}
	
}