package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Section;

public interface SectionDAO {
	//섹션 등록
	public void insert(Section section) throws Exception;
	
	//섹션 조회 
	public List selectBylectureID(int lecture_id) throws Exception;
	
}
