package com.eroom.gw.survey.domain;

public class SurveyItem {

	private int surveyNo;
	private int itemNo;
	private int itemValue;
	private String memberName;
	
	public SurveyItem() {}

	public int getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemValue() {
		return itemValue;
	}

	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "SurveyItem [surveyNo=" + surveyNo + ", itemNo=" + itemNo + ", itemValue=" + itemValue + ", memberName="
				+ memberName + "]";
	}
	
	
}
