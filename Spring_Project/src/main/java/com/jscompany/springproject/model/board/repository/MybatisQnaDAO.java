package com.jscompany.springproject.model.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.board.Qna;
@Repository
public class MybatisQnaDAO implements QnaDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insertQna(Qna qna) throws Exception {
		return sqlSessionTemplate.insert("Qna.insert", qna);
	}

	public List select() throws Exception {
		return sqlSessionTemplate.selectList("Qna.select");
	}

	public Qna selectById(int qna_id) throws Exception {
		return sqlSessionTemplate.selectOne("Qna.selectById", qna_id);
	}

	public int update(Qna qna) throws Exception {
		return sqlSessionTemplate.update("Qna.update", qna);
	}

	public int delete(int qna_id) throws Exception {
		return sqlSessionTemplate.delete("Qna.delete", qna_id);
	}

}
