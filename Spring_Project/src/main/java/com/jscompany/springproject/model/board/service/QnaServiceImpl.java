package com.jscompany.springproject.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.board.repository.QnaDAO;
import com.jscompany.springproject.model.domain.board.Qna;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int registQna(Qna qna) throws Exception {
		return qnaDAO.insertQna(qna);
	}

	public List select() throws Exception {
		return qnaDAO.select();
	}

	public Qna selectById(int qna_id) throws Exception {
		return qnaDAO.selectById(qna_id);
	}

	public int update(Qna qna) throws Exception {
		return qnaDAO.update(qna);
	}

	public int delete(int qna_id) throws Exception {
		return qnaDAO.delete(qna_id);
	}
}
