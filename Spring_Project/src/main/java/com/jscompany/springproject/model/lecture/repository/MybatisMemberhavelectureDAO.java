package com.jscompany.springproject.model.lecture.repository;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMemberhavelectureDAO implements MemberhavelectureDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//수강 등록
	public int courseInsert(Map mapId) throws Exception { 
		return sqlSessionTemplate.insert("Memberhavelecture.insert", mapId);
	}
	
	//아이디 값을 이용하여 조회
	public int selectByMemberLectureID(Map mapId) throws Exception {
		return sqlSessionTemplate.selectOne("Memberhavelecture.selectByMemberLectureID", mapId);
	}

}
