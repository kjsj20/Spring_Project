package com.jscompany.springproject.model.board.service;

import java.util.List;

import com.jscompany.springproject.model.domain.board.Qna;

public interface QnaService {
	// Qna 쓰기.
	public int registQna(Qna qna) throws Exception;

	// Qna 조회
	public List select() throws Exception;

	// Qna 디테일 조회
	public Qna selectById(int qna_id) throws Exception;

	// Qna 수정
	public int update(Qna qna) throws Exception;

	// Qna 삭제
	public int delete(int qna_id) throws Exception;
}
