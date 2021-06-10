package com.eroom.gw.survey.store;

import java.util.ArrayList;

import com.eroom.gw.survey.domain.SurveyItem;
import com.eroom.gw.survey.domain.SurveyList;

public interface SurveyStore {
	
	public int insertSurvey(SurveyList surveyList);
	public int deleteSurvey(int surveyNo);
	public ArrayList<SurveyList> selectAllSurvey(String memberDept);
	public SurveyList selectOneSurvey(int surveyNo);
	public int insertSurveyItem(SurveyItem surveyItem);
	public int totalCount(int surveyNo);
	public ArrayList<SurveyItem> selectAllResult(int surveyNo);
	public ArrayList<SurveyItem> selectResultCount(int surveyNo);
	public int checkSurvey(SurveyItem surveyItem);

}
