package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Section;
import com.jscompany.springproject.model.domain.lecture.Section_detail;

public interface SectionService {
	public void regist(Section section, Section_detail section_detail,List<String> classList,List<String> urlList,List<Integer> countList ,List<String> sectionList) throws Exception;
}