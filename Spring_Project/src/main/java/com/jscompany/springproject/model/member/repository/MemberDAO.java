package com.jscompany.springproject.model.member.repository;

import java.util.List;
import java.util.Map;

import com.jscompany.springproject.model.domain.member.Member;

public interface MemberDAO {
	public List selectAll() throws Exception;
	public Member select(Member member) throws Exception;
	public void insert(Member member) throws Exception;
	public void updateAuthKey(Map map) throws Exception;
	public void updateAuthStatus(Map map) throws Exception;
	public int idCheck(Member member) throws Exception;
	public void delete(int member_id) throws Exception;
}
