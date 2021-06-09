package com.eroom.gw.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eroom.gw.survey.service.SurveyService;

@Controller
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="surveyList.do")
	public String regSurveyForm() {
		return "survey/surveyForm";
	}
	
	@RequestMapping(value="regSurvey.do", method=RequestMethod.POST)
	public String regSurvey() {
		
		
		return null;
	}
}
