package com.eroom.gw.survey.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eroom.gw.member.domain.Member;
import com.eroom.gw.survey.domain.SurveyList;
import com.eroom.gw.survey.service.SurveyService;

@Controller
public class SurveyController {

	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="surveyList.do")
	public String surveyListAll() {
		return "survey/surveyList";
	}
	
	
	
	@RequestMapping(value="surveyForm.do")
	public String regSurveyForm() {
		return "survey/surveyForm";
	}
	
	@ResponseBody
	@RequestMapping(value="regSurvey.do", method=RequestMethod.POST)
	public String regSurvey(@ModelAttribute SurveyList surveyList, HttpSession session) {
		Member member = (Member)session.getAttribute("LoginUser");
		surveyList.setMemberId(member.getMemberId());
		System.out.println(surveyList);
		int result = surveyService.registerSurvey(surveyList);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
