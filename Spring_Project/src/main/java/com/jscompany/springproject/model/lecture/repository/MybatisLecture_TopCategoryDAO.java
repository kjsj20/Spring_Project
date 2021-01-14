package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisLecture_TopCategoryDAO implements Lecture_TopCategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() throws Exception {		
		return sqlSessionTemplate.selectList("Lecture_TopCategory.selectAll");
	}

}
