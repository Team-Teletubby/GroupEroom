package com.eroom.gw.survey.domain;

public class SurveyItem {

	private int surveyNo;
	private String itemValue;
	private String memberName;
	private int count;
	
	public SurveyItem() {}

	public int getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SurveyItem [surveyNo=" + surveyNo + ", itemValue=" + itemValue + ", memberName=" + memberName
				+ ", count=" + count + "]";
	}


	
}
