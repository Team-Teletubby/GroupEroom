package com.eroom.gw.survey.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eroom.gw.survey.store.SurveyStore;

@Repository
public class SurveyStoreLogic implements SurveyStore{
	
	@Autowired
	private SqlSession sqlSession;

}
