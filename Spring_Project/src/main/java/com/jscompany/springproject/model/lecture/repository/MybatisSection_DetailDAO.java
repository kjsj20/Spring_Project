package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.lecture.Section_detail;

@Repository
public class MybatisSection_DetailDAO implements Section_DetailDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insert(Section_detail section_detail) throws Exception {
		sqlSessionTemplate.insert("Section_detail.insert", section_detail);
	}

	public List selectBySectionId(int section_id) throws Exception {
		return sqlSessionTemplate.selectList("Section_detail.selectBySectionId", section_id);
	}

}
