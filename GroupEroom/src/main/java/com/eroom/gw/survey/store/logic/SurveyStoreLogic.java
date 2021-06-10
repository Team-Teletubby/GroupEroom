package com.eroom.gw.survey.store.logic;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.survey.domain.SurveyList;
import com.eroom.gw.survey.store.SurveyStore;

@Repository
public class SurveyStoreLogic implements SurveyStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertSurvey(SurveyList surveyList) {
		return sqlSession.insert("surveyMapper.insertSurveyList", surveyList);
	}

	@Override
	public int deleteSurvey(int surveyNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<SurveyList> selectAllSurvey(String memberDept) {
		return (ArrayList)sqlSession.selectList("surveyMapper.selectAllSurvey", memberDept);
	}

	@Override
	public SurveyList selectOneSurvey(int surveyNo) {
		return sqlSession.selectOne("surveyMapper.selectOneSurvey", surveyNo);
	}

}
