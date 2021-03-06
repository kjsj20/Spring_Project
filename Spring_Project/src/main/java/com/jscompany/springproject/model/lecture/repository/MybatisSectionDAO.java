package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.lecture.Section;

@Repository
public class MybatisSectionDAO implements SectionDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	 
	//섹션 등록
	public void insert(Section section) throws Exception {
		 sqlSessionTemplate.insert("Section.insert", section);
	}
	
	//섹션 조회
	public List selectBylectureID(int lecture_id) throws Exception {
		return sqlSessionTemplate.selectList("Section.selectBylectureID", lecture_id);
	}

}
