package com.jscompany.springproject.model.member.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jscompany.springproject.model.domain.member.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List selectAll() throws Exception {		 
		return sqlSessionTemplate.selectList("Member.selectAll");
	}
	
	public Member select(Member member)  throws Exception{
		Member obj= sqlSessionTemplate.selectOne("Member.select", member);
		return obj;
	}
	
	public void insert(Member member) throws Exception { 
		sqlSessionTemplate.insert("Member.insert", member);
	}

	public void updateAuthKey(Map map)throws Exception {
		sqlSessionTemplate.update("Member.updateAuthKey", map);
	}

	public void updateAuthStatus(Map map)throws Exception {
		sqlSessionTemplate.update("Member.updateAuthStatus", map);
	}

	public int idCheck(Member member) throws Exception {
		return sqlSessionTemplate.selectOne("Member.idCheck", member);
	}

	@Override
	public void delete(int member_id) throws Exception {
		sqlSessionTemplate.delete("Member.delete", member_id);
	}

}
