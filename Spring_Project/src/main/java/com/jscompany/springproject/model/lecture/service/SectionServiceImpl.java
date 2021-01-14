package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.domain.lecture.Section;
import com.jscompany.springproject.model.domain.lecture.Section_detail;
import com.jscompany.springproject.model.lecture.repository.SectionDAO;
import com.jscompany.springproject.model.lecture.repository.Section_DetailDAO;

@Service
public class SectionServiceImpl implements SectionService{

	@Autowired
	private SectionDAO sectionDAO;
	
	@Autowired
	private Section_DetailDAO section_DetailDAO;
	
	public void regist(Section section, Section_detail section_detail,List<String> classList,List<String> urlList,List<Integer> countList ,List<String> sectionList) throws Exception {
		for(int i =0; i < sectionList.size(); i++) {
			section.setSection_name(sectionList.get(i));
			sectionDAO.insert(section);
			section_detail.setSection_id(section.getSection_id());
			
			for(int j=0; j < countList.get(i); j++) {
				 section_detail.setSection_detail_name(classList.get(0));
				 section_detail.setSection_lectureurl(urlList.get(0));
				 classList.remove(0);
				 urlList.remove(0);
				 section_DetailDAO.insert(section_detail);
			}
		}
	}

}
