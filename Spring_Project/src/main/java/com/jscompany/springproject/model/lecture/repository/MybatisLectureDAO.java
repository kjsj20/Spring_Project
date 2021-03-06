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

	public Lecture selectByLectureId(int lecture_id) throws Exception {
		return sqlSessionTemplate.selectOne("Lecture.selectByLectureId", lecture_id);
	}
	
	//강의 등록 
	public void insert(Lecture lecture) throws Exception{
		int result = sqlSessionTemplate.insert("Lecture.insert", lecture) ;
		if(result==0) {
			throw new LectureRegistException("강의 등록중 에러가 발생하였습니다..");
		}
	}
	
	//강의 수정
	public int update(Lecture lecture) throws Exception {
		 int result = sqlSessionTemplate.update("Lecture.update", lecture);
		 return  result;
	}
	
	//강의 삭제
	public int delete(int lecture_id) throws Exception {		
		return sqlSessionTemplate.delete("Lecture.delete",lecture_id);
	}
	
	//탑카테고리 선택시 해당 카테고리에 있는 강의 전체 보여주기
	public List selectByTopId(int topcategory_id) throws Exception {
		return sqlSessionTemplate.selectList("Lecture.selectByTopId", topcategory_id);
	}

	public List selectSubList(int subcategory_id) throws Exception {
		return sqlSessionTemplate.selectList("Lecture.selectSubList", subcategory_id);
	}

	public List selectByMemberId(int member_id) throws Exception {
		return sqlSessionTemplate.selectList("Lecture.selectByMemberId", member_id);
	}

	public List selectMainList() throws Exception {
		return sqlSessionTemplate.selectList("Lecture.selectMainList");
	}

}
