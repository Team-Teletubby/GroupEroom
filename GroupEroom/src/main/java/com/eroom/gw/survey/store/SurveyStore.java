package com.eroom.gw.survey.store;

import java.util.ArrayList;

import com.eroom.gw.survey.domain.SurveyList;

public interface SurveyStore {
	
	public int insertSurvey(SurveyList surveyList);
	public int deleteSurvey(int surveyNo);
	public ArrayList<SurveyList> selectAllSurvey(String memberDept);

}
