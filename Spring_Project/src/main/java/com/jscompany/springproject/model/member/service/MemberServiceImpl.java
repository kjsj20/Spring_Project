package com.jscompany.springproject.model.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.common.SecureManager;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private SecureManager secureManager;  
	
	public List selectAll() throws Exception{
		return memberDAO.selectAll();
	}
	
	public Member select(Member member)  throws Exception{
		String hash = secureManager.getSecureData(member.getPassword());
		member.setPassword(hash);
		Member obj = memberDAO.select(member);
		return obj;
	}
	
	public void regist(Member member) throws Exception{
		//암호화 처리!
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData);
		//db에 입력
		memberDAO.insert(member);
	}

	public void updateAuthKey(Map map) throws Exception{
		memberDAO.updateAuthKey(map);
	}

	public void updateAuthStatus(Map map) throws Exception{
		memberDAO.updateAuthStatus(map);
	}

	public int idCheck(Member member) throws Exception{
		return memberDAO.idCheck(member);
	}

	@Override
	public void delete(int member_id) throws Exception{
		memberDAO.delete(member_id);
	}

}
