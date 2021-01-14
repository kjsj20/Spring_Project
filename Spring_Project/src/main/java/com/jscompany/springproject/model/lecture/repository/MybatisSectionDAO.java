package com.jscompany.springproject.model.lecture.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.lecture.Section;

@Repository
public class MybatisSectionDAO implements SectionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	 
	public void insert(Section section) throws Exception {
		 sqlSessionTemplate.insert("Section.insert", section);
	}

}