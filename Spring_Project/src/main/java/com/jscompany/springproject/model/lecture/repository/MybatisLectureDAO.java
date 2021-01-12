package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.exception.LectureRegistException;
import com.jscompany.springproject.model.domain.lecture.Lecture;

@Repository
public class MybatisLectureDAO implements LectureDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	
	public List selectAllById(int member_id) throws Exception {
		return sqlSessionTemplate.selectList("Lecture.selectAllById", member_id);
	}

	public Lecture selectByLectureId(Lecture lecture) throws Exception {
		return null;
	}
	
	//강의 등록 
	@Override
	public void insert(Lecture lecture) throws Exception{
		int result = sqlSessionTemplate.insert("Lecture.insert", lecture) ;
		if(result==0) {
			throw new LectureRegistException("강의 등록중 에러가 발생하였습니다..");
		}
	}

}
