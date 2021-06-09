package com.eroom.gw.survey.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eroom.gw.survey.service.SurveyService;
import com.eroom.gw.survey.store.SurveyStore;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private SurveyStore surveyStore;

}
