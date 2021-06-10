package com.eroom.gw.survey.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	// 투표 리스트
	@RequestMapping(value="surveyList.do")
	public String surveyListAll(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("LoginUser");
		String memberDept = member.getMemberDept();
		
		ArrayList<SurveyList> list = surveyService.selectAllSurvey(memberDept);
		System.out.println(list);
		model.addAttribute("list", list);
		return "survey/surveyList";
	}
	
	@RequestMapping(value="surveyOne.do")
	public String printOne(Model model, @RequestParam(value="surveyNo")int surveyNo) {
		SurveyList survey = surveyService.selectOneSurvey(surveyNo);
		if(survey!=null) {
			model.addAttribute("survey",survey);
			return "survey/surveyDetail";
		}else {
			return "";
		}
		
	}
	
	
	// 투표 폼
	@RequestMapping(value="surveyForm.do")
	public String regSurveyForm() {
		return "survey/surveyForm";
	}
	
	// 투표 등록
	@ResponseBody
	@RequestMapping(value="regSurvey.do", method=RequestMethod.POST)
	public String regSurvey(@ModelAttribute SurveyList surveyList, HttpSession session) {
		Member member = (Member)session.getAttribute("LoginUser");
		System.out.println(surveyList.getEndDate());
		surveyList.setMemberId(member.getMemberId());
		int result = surveyService.registerSurvey(surveyList);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
