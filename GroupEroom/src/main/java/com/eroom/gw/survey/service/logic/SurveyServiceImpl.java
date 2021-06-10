package com.eroom.gw.survey.service.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SurveyList> selectAllSurvey(String memberDept) {
		return surveyStore.selectAllSurvey(memberDept);
	}

	@Override
	public SurveyList selectOneSurvey(int surveyNo) {
		return surveyStore.selectOneSurvey(surveyNo);
	}

}
