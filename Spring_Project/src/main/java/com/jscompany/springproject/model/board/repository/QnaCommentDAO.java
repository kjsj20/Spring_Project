package com.jscompany.springproject.model.board.repository;

import java.util.List;

import com.jscompany.springproject.model.domain.board.Qna_Comment;

public interface QnaCommentDAO {
	public int insert(Qna_Comment qna_Comment) throws Exception;
	public List selectCmmt(int qna_id) throws Exception;
	public int delete(int qna_comment_id) throws Exception;
}
