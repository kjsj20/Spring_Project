package com.jscompany.springproject.model.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.common.RandomPassword;
import com.jscompany.springproject.common.SecureManager;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private SecureManager secureManager;  
	
	@Autowired
	private RandomPassword randomPassword;
	
	@Autowired
	private MailSendService mss;
	
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
	
	//회원 삭제 
	public int delete(int member_id) throws Exception{
		return memberDAO.delete(member_id);
	}

	//회원 아이디 찾기
	public String idSearch(String phone_number) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.idSearch(phone_number);
	}
	
	//회원 비밀번호 찾기
	public int passSearch(Member member) throws Exception {
		String randomPass = randomPassword.getRamdomPassword(10);
		//암호화 처리!
		String secureData = secureManager.getSecureData(randomPass);
		member.setPassword(secureData);
		int result = memberDAO.passSearchUpdate(member);
		if(result == 1) {
			mss.sendPassword(member.getE_mail(), randomPass);			
		}
		return result;
	}
	
	//멤버 이름 변경
	public int nameUpdate(Member member) throws Exception {
		return memberDAO.nameUpdate(member);
	}
	
	//멤버 암호 변경
	public int passUpdate(Member member) throws Exception {
		//암호화 처리!
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData);
		return memberDAO.passUpdate(member);
	}

	//멤버 휴대전화번호 변경
	public int phoneUpdate(Member member) throws Exception {
		return memberDAO.phoneUpdate(member);
	}

	//멤버 생년월일 변경
	public int birthUpdate(Member member) throws Exception {
		return memberDAO.birthUpdate(member);
	}

}
