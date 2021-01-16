package com.jscompany.springproject.model.lecture.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.domain.lecture.Memberhavelecture;
import com.jscompany.springproject.model.lecture.repository.MemberhavelectureDAO;

@Service
public class MemberhavelectureServiceImpl implements MemberhavelectureService{
	
	@Autowired
	private MemberhavelectureDAO memberhavelectureDAO;
	//수강등록
	public int courseRegist(Map mapId) throws Exception {
		return memberhavelectureDAO.courseInsert(mapId);
	}
	
	//아이디 값을 이용하여 조회
	public int selectByMemberLectureID(Map mapId) throws Exception {
		return memberhavelectureDAO.selectByMemberLectureID(mapId);
	}

	

}
