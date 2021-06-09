package com.eroom.gw.survey.domain;

public class SurveyList {
	
	private int surveyNo;
	private int memberId;
	private String showName;
	private String showResult;
	private String surveyTitle;
	private String surveyObject;
	private String surveyQuestion;
	private String surveyAnswers;
	private String target;
	private String startDate;
	private String endDate;
	private String writeDate;
	private String finished;
	private String overlap;
	
	public SurveyList() {}

	public int getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowResult() {
		return showResult;
	}

	public void setShowResult(String showResult) {
		this.showResult = showResult;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public String getSurveyObject() {
		return surveyObject;
	}

	public void setSurveyObject(String surveyObject) {
		this.surveyObject = surveyObject;
	}

	public String getSurveyQuestion() {
		return surveyQuestion;
	}

	public void setSurveyQuestion(String surveyQuestion) {
		this.surveyQuestion = surveyQuestion;
	}

	public String getSurveyAnswers() {
		return surveyAnswers;
	}

	public void setSurveyAnswers(String surveyAnswers) {
		this.surveyAnswers = surveyAnswers;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getOverlap() {
		return overlap;
	}

	public void setOverlap(String overlap) {
		this.overlap = overlap;
	}

	@Override
	public String toString() {
		return "SurveyList [surveyNo=" + surveyNo + ", memberId=" + memberId + ", showName=" + showName
				+ ", showResult=" + showResult + ", surveyTitle=" + surveyTitle + ", surveyObject=" + surveyObject
				+ ", surveyQuestion=" + surveyQuestion + ", surveyAnswers=" + surveyAnswers + ", target=" + target
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", writeDate=" + writeDate + ", finished="
				+ finished + ", overlap=" + overlap + "]";
	}

	
	
}