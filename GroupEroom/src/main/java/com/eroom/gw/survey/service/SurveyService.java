package com.eroom.gw.survey.service;

import java.util.ArrayList;

import com.eroom.gw.survey.domain.SurveyItem;
import com.eroom.gw.survey.domain.SurveyList;

public interface SurveyService {
	
	public int registerSurvey(SurveyList surveyList);
	public int removeSurvey(int surveyNo);
	public ArrayList<SurveyList> selectAllSurvey(String memberDept);
	public SurveyList selectOneSurvey(int surveyNo);
	public int completeSurvey(SurveyItem surveyItem);
	public int totalCount(int surveyNo);
	public ArrayList<SurveyItem> selectAllResult(int surveyNo);
	public ArrayList<SurveyItem> selectResultCount(int surveyNo);
	public int checkSurvey(SurveyItem surveyItem);

}
