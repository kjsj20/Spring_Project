package com.jscompany.springproject.model.lecture.repository;

import java.util.Map;

public interface MemberhavelectureDAO {
	//수강 등록
	public int courseInsert(Map mapId) throws Exception; 
	//이미 가지고 있는지 확인을 위해 셀렉트 
	public int selectByMemberLectureID(Map mapId) throws Exception;
}
