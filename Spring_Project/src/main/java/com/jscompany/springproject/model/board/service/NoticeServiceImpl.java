package com.jscompany.springproject.model.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.board.repository.NoticeDAO;
import com.jscompany.springproject.model.domain.board.Notice;

@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeDAO noticeDAO;
	
	//공지사항 쓰기 
	public int registNotice(Notice notice) throws Exception {
		return noticeDAO.insertNotice(notice);
	}
	
	//공지사항 조회
	public List select() throws Exception {
		return noticeDAO.select();
	}
	
	//공지사항 디테일 조회
	public Notice selectById(int notice_id) throws Exception {
		return noticeDAO.selectById(notice_id);
	}
	
	//공지사항 수정
	public int update(Notice notice) throws Exception {
		return noticeDAO.update(notice);
	}
	
	//공지사항 삭제
	public int delete(int notice_id) throws Exception {
		return noticeDAO.delete(notice_id);
	}

}
