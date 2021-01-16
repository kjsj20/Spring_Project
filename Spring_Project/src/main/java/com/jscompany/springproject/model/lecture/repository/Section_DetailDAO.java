package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Section_detail;

public interface Section_DetailDAO {
	//섹션 등록
	public void insert(Section_detail section_detail) throws Exception;
	
	//섹션 세부정보 조회
	public List selectBySectionId(int section_id) throws Exception;
}
