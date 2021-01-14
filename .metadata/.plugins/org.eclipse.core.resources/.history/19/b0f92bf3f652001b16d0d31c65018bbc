package com.jscompany.springproject.model.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.exception.DuplicateCheckException;
import com.jscompany.springproject.model.domain.Member;
import com.jscompany.springproject.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memberDAO;
	
	public List selectAll() {
		return memberDAO.selectAll();
	}

	public void regist(Member member) {
		memberDAO.insert(member);
	}

	public void updateAuthKey(Map map) {
		memberDAO.updateAuthKey(map);
	}

	public void updateAuthStatus(Map map) {
		memberDAO.updateAuthStatus(map);
	}

	public int idCheck(Member member) throws Exception{
		return memberDAO.idCheck(member);
	}
	
}
