package com.jscompany.springproject.model.member.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List selectAll() {		 
		return sqlSessionTemplate.selectList("Member.selectAll");
	}
	
	public Member select(Member member)  throws Exception{
		Member obj= sqlSessionTemplate.selectOne("Member.select", member);
		return obj;
	}
	
	public void insert(Member member) { 
		sqlSessionTemplate.insert("Member.insert", member);
	}

	public void updateAuthKey(Map map) {
		sqlSessionTemplate.update("Member.updateAuthKey", map);
	}

	public void updateAuthStatus(Map map) {
		sqlSessionTemplate.update("Member.updateAuthStatus", map);
	}

	public int idCheck(Member member) throws Exception {
		return sqlSessionTemplate.selectOne("Member.idCheck", member);
	}

}
