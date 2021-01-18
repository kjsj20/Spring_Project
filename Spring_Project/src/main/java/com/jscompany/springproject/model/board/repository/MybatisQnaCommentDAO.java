package com.jscompany.springproject.model.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.board.Qna_Comment;

@Repository
public class MybatisQnaCommentDAO implements QnaCommentDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Qna_Comment qna_Comment) throws Exception {
		return sqlSessionTemplate.insert("Qna_Comment.insert", qna_Comment);
	}

	public List selectCmmt(int qna_id) throws Exception {
		return sqlSessionTemplate.selectList("Qna_Comment.selectCmmt", qna_id);
	}

	public int delete(int qna_comment_id) throws Exception {
		return sqlSessionTemplate.delete("Qna_Comment.delete", qna_comment_id);
	}
}
