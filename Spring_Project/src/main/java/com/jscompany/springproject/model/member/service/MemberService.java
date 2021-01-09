package com.jscompany.springproject.model.member.service;

import java.util.List;
import java.util.Map;

import com.jscompany.springproject.model.domain.Member;

public interface MemberService {
	public List selectAll();
	public void regist(Member member);
	public void updateAuthKey(Map map);
	public void updateAuthStatus(Map map);
	public int idCheck(Member member) throws Exception;
}
