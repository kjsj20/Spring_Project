package com.jscompany.springproject.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

/*
 * 일단 암호화 된 이후에, 복호화 시킬 수 없는 SHA알고리즘으로 회원의 비밀번호를 암호화시켜주는 객체
 * */
@Component
public class SecureManager {
	public String getSecureData(String password) {
		
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] data = password.getBytes("UTF-8");
			byte[] hash = digest.digest(data);
			
			//쪼개진 데이터를 대상으로 16진수값으로 변환하여 문자열로 변환
			for(int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff&hash[i]);
				if(hex.length()==1) {
					sb.append("0");
				} 
				sb.append(hex);					
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}	
}
