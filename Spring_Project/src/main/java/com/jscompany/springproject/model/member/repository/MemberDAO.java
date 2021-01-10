package com.jscompany.springproject.model.member.repository;

import java.util.List;
import java.util.Map;

import com.jscompany.springproject.model.domain.Member;

public interface MemberDAO {
	public List selectAll();
	public Member select(Member member) throws Exception;
	public void insert(Member member);
	public void updateAuthKey(Map map);
	public void updateAuthStatus(Map map);
	public int idCheck(Member member) throws Exception;
}
