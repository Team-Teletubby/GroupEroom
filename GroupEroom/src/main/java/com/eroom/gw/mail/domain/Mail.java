package com.eroom.gw.mail.domain;

import java.sql.Date;

public class Mail {

	private int mailNo;
	private String mailTitle;
	private String mailContents;
	private String mailFile;
	private String readState;
	private Date sendDate;
	private String mailCheck;
	
	public Mail() {}

	public Mail(int mailNo, String mailTitle, String mailContents, String mailFile, String readState, Date sendDate,
			String mailCheck) {
		super();
		this.mailNo = mailNo;
		this.mailTitle = mailTitle;
		this.mailContents = mailContents;
		this.mailFile = mailFile;
		this.readState = readState;
		this.sendDate = sendDate;
		this.mailCheck = mailCheck;
	}

	public int getMailNo() {
		return mailNo;
	}

	public void setMailNo(int mailNo) {
		this.mailNo = mailNo;
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

	public String getMailFile() {
		return mailFile;
	}

	public void setMailFile(String mailFile) {
		this.mailFile = mailFile;
	}

	public String getReadState() {
		return readState;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getMailCheck() {
		return mailCheck;
	}

	public void setMailCheck(String mailCheck) {
		this.mailCheck = mailCheck;
	}

	@Override
	public String toString() {
		return "Mail [mailNo=" + mailNo + ", mailTitle=" + mailTitle + ", mailContents=" + mailContents + ", mailFile="
				+ mailFile + ", readState=" + readState + ", sendDate=" + sendDate + ", mailCheck=" + mailCheck + "]";
	} 
	
	
}
