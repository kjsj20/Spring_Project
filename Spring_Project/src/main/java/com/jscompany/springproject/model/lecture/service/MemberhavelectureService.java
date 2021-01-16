package com.jscompany.springproject.model.lecture.service;

import java.util.Map;

import com.jscompany.springproject.model.domain.lecture.Memberhavelecture;

public interface MemberhavelectureService {
	
	//수강등록
	public int courseRegist(Map mapId) throws Exception;
	
	//이미 가지고 있는지 확인을 위해 셀렉트 
	public int selectByMemberLectureID(Map mapId) throws Exception;
}
