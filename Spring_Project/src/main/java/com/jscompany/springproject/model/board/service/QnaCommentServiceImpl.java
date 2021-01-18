package com.jscompany.springproject.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.board.repository.QnaCommentDAO;
import com.jscompany.springproject.model.domain.board.Qna_Comment;

@Service
public class QnaCommentServiceImpl implements QnaCommentService{
	
	@Autowired
	private QnaCommentDAO qnaCommentDAO;
	
	public int regist(Qna_Comment qna_Comment) throws Exception {
		return qnaCommentDAO.insert(qna_Comment);
	}

	public List selectCmmt(int qna_id) throws Exception {
		return qnaCommentDAO.selectCmmt(qna_id);
	}

	public int delete(int qna_comment_id) throws Exception {
		return qnaCommentDAO.delete(qna_comment_id);
	}

}
