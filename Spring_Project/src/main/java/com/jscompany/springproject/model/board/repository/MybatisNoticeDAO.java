package com.jscompany.springproject.model.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.board.Notice;

@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	//공지사항 쓰기.
	public int insertNotice(Notice notice) throws Exception {
		return sqlSessionTemplate.insert("Notice.insert", notice);
	}
	
	//공지사항 조회
	public List select() throws Exception {
		return sqlSessionTemplate.selectList("Notice.select");
	}
	
	//공지사항 디테일조회
	public Notice selectById(int notice_id) throws Exception {
		return sqlSessionTemplate.selectOne("Notice.selectById", notice_id);
	}
	
	//공지사항 수정
	public int update(Notice notice) throws Exception {
		return sqlSessionTemplate.update("Notice.update", notice);
	}

	//공지사항 삭제
	public int delete(int notice_id) throws Exception {
		return sqlSessionTemplate.delete("Notice.delete",notice_id);
	}

}
