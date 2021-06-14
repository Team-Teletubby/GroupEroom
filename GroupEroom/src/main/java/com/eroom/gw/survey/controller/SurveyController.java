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
import com.eroom.gw.survey.domain.SurveyItem;
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
		model.addAttribute("list", list);
		return "survey/surveyList";
	}
	
	//투표 디테일
	@RequestMapping(value="surveyOne.do")
	public String printOne(HttpSession session,Model model, @RequestParam(value="surveyNo")int surveyNo) {
		Member member = (Member)session.getAttribute("LoginUser");
		String memberName = member.getMemberName();
		SurveyItem surveyItem = new SurveyItem();
		surveyItem.setMemberName(memberName);
		surveyItem.setSurveyNo(surveyNo);
		int check = surveyService.checkSurvey(surveyItem);
		SurveyList survey = surveyService.selectOneSurvey(surveyNo);
		if(survey!=null) {
			model.addAttribute("check", check);
			model.addAttribute("survey",survey);
			return "survey/surveyDetail";
		}else {
			return "";
		}
		
	}
	
	// 투표하기
	@RequestMapping(value="surveyComplete.do", method=RequestMethod.POST)
	public String completeSurvey(HttpSession session,@RequestParam("surveyNo") int surveyNo, @RequestParam("itemValue")String itemValue) {
		Member member = (Member)session.getAttribute("LoginUser");
		SurveyItem surveyItem = new SurveyItem();
		surveyItem.setMemberName(member.getMemberName());
		surveyItem.setSurveyNo(surveyNo);
		surveyItem.setItemValue(itemValue);
		
		
		int result = surveyService.completeSurvey(surveyItem);
		if(result > 0) {
			return "redirect:surveyOne.do?surveyNo="+surveyNo;
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
		surveyList.setMemberId(member.getMemberId());
		int result = surveyService.registerSurvey(surveyList);
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	
	// 투표 결과보기
	@RequestMapping(value="resultSurvey.do")
	public String resultSurvey(Model model, @RequestParam("surveyNo")int surveyNo){
		SurveyList survey = surveyService.selectOneSurvey(surveyNo);
		int totalCount = surveyService.totalCount(surveyNo);
		ArrayList<SurveyItem> resultCount = surveyService.selectResultCount(surveyNo);
		ArrayList<SurveyItem> resultAll = surveyService.selectAllResult(surveyNo);
		model.addAttribute("resultCount",resultCount);
		model.addAttribute("resultAll",resultAll);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("survey",survey);
		return "survey/surveyResult";
	}
	
	//투표 삭제
	@RequestMapping(value="deleteSurvey.do")
	public String deleteSurvey(@RequestParam("surveyNo")int surveyNo) {
		int result = surveyService.removeSurvey(surveyNo);
		if(result>0) {
			return "redirect:surveyList.do";
		}else {
			return"";
		}
	}
}
