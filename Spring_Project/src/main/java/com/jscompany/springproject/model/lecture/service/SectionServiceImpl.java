package com.jscompany.springproject.model.lecture.service;

import java.util.ArrayList;
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
	
	//섹션 등록
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
	
	//섹션 조회
	public List selectBylectureID(int lecture_id) throws Exception{
		return sectionDAO.selectBylectureID(lecture_id);
	}
	
	//섹션 세부정보 조회
	public List selectBySectionId(List<Section> sectionList) throws Exception {
		List detailList = null;
		List sectionDetailListList = new ArrayList();
		for(int i = 0; i < sectionList.size(); i++) {
			Section section = sectionList.get(i); 
			detailList = section_DetailDAO.selectBySectionId(section.getSection_id());
			sectionDetailListList.add(detailList);
		}
		return sectionDetailListList;
	}

}
