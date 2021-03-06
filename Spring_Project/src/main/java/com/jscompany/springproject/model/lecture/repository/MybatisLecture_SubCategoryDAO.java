package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisLecture_SubCategoryDAO implements Lecture_SubCategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List selectByTopId(int lecture_topcategory_id) throws Exception {
		return sqlSessionTemplate.selectList("Lecture_SubCategory.selectByTopId", lecture_topcategory_id);
	}

}
