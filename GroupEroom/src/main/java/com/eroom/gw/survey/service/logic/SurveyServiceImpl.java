package com.eroom.gw.survey.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.survey.domain.SurveyItem;
import com.eroom.gw.survey.domain.SurveyList;
import com.eroom.gw.survey.service.SurveyService;
import com.eroom.gw.survey.store.SurveyStore;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private SurveyStore surveyStore;

	@Override
	public int registerSurvey(SurveyList surveyList) {
		return surveyStore.insertSurvey(surveyList);
	}

	@Override
	public int removeSurvey(int surveyNo) {
		return surveyStore.deleteSurvey(surveyNo);
	}

	@Override
	public ArrayList<SurveyList> selectAllSurvey(String memberDept) {
		return surveyStore.selectAllSurvey(memberDept);
	}

	@Override
	public SurveyList selectOneSurvey(int surveyNo) {
		return surveyStore.selectOneSurvey(surveyNo);
	}

	@Override
	public int completeSurvey(SurveyItem surveyItem) {
		return surveyStore.insertSurveyItem(surveyItem);
	}

	@Override
	public int totalCount(int surveyNo) {
		return surveyStore.totalCount(surveyNo);
	}

	@Override
	public ArrayList<SurveyItem> selectAllResult(int surveyNo) {
		return surveyStore.selectAllResult(surveyNo);
	}

	@Override
	public ArrayList<SurveyItem> selectResultCount(int surveyNo) {
		return surveyStore.selectResultCount(surveyNo);
	}

	@Override
	public int checkSurvey(SurveyItem surveyItem) {
		return surveyStore.checkSurvey(surveyItem);
	}

}
