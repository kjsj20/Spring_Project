package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Section;
import com.jscompany.springproject.model.domain.lecture.Section_detail;

public interface SectionService {
	//섹션 등록
	public void regist(Section section, Section_detail section_detail,List<String> classList,List<String> urlList,List<Integer> countList ,List<String> sectionList) throws Exception;
	
	//섹션 조회 
	public List selectBylectureID(int lecture_id) throws Exception;
	
	//섹션 세부정보 조회
	public List selectBySectionId(List<Section> sectionList) throws Exception;
}
