package com.eroom.gw.survey.service;

import java.util.ArrayList;

import com.eroom.gw.survey.domain.SurveyList;

public interface SurveyService {
	
	public int registerSurvey(SurveyList surveyList);
	public int removeSurvey(int surveyNo);
	public ArrayList<SurveyList> selectAllSurvey(String memberDept);
	public SurveyList selectOneSurvey(int surveyNo);

}
