package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.lecture.Difficulty;

@Repository
public class MybatisDifficultyDAO implements DifficultyDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List selectAll() throws Exception {
		return sqlSessionTemplate.selectList("Difficulty.selectAll");
	}

}
