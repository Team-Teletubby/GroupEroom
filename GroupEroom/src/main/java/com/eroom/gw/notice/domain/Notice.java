package com.eroom.gw.notice.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {

	
	private int noticeNo;
	private int memberId;
	private String noticeTitle;
	private String memberName;
	private String noticeContents;
	private Date enrollDate;
	private int hits;
	private String originalFileName;
	private String renameFileName;
	
	
}