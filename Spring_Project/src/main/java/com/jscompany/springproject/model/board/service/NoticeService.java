package com.jscompany.springproject.model.board.service;

import java.util.List;

import com.jscompany.springproject.model.domain.board.Notice;

public interface NoticeService {
	//공지사항 쓰기.
	public int registNotice(Notice notice) throws Exception;
	//공지사항 조회
	public List select() throws Exception;
	//공지사항 디테일 조회 
	public Notice selectById(int notice_id) throws Exception;
	//공지사항 수정
	public int update(Notice notice) throws Exception;
	//공지사항 삭제
	public int delete(int notice_id) throws Exception;
}
