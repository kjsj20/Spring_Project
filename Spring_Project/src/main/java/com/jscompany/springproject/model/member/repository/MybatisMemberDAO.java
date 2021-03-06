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
	
	//멤버 삭제
	public int delete(int member_id) throws Exception {
		return sqlSessionTemplate.delete("Member.delete", member_id);
	}
	
	//멤버 아이디 찾기
	public String idSearch(String phone_number) throws Exception {
		return sqlSessionTemplate.selectOne("Member.idSearch",phone_number);
	}
	
	//비밀번호 찾기 시 임시 비밀번호가 저장됨
	public int passSearchUpdate(Member member) throws Exception {
		return sqlSessionTemplate.update("Member.passSearchUpdate", member);
	}
	
	//멤버 이름 수정
	public int nameUpdate(Member member) throws Exception {
		return sqlSessionTemplate.update("Member.nameUpdate", member);
	}
	
	//멤버 암호 수정
	public int passUpdate(Member member) throws Exception {
		return sqlSessionTemplate.update("Member.passUpdate", member);
	}
	
	//멤버 휴대전화번호 수정
	public int phoneUpdate(Member member) throws Exception {
		return sqlSessionTemplate.update("Member.phoneUpdate", member);
	}
	
	//멤버 생년월일 수정
	public int birthUpdate(Member member) throws Exception {
		return sqlSessionTemplate.update("Member.birthUpdate", member);
	}

}
