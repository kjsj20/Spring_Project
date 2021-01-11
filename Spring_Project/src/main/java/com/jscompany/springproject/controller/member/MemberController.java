package com.jscompany.springproject.controller.member;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jscompany.springproject.common.RSAUtil;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.domain.member.RSA;
import com.jscompany.springproject.model.member.service.MailSendService;
import com.jscompany.springproject.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private MailSendService mss;
	
	@Autowired
	private RSAUtil rsaUtil;
	
	@PostMapping("/member/signup")
	@ResponseBody
	public int regist(Member member) throws Exception{
		
		int result = memberService.idCheck(member);
		
		if(result==0) {			
			memberService.regist(member);
			String authKey = mss.sendAuthMail(member.getE_mail());
			member.setAuthkey(authKey);
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("e_mail", member.getE_mail());
			map.put("authKey", member.getAuthkey());
			
			memberService.updateAuthKey(map);
		}
		
		return result;
	}
	
	@GetMapping("/member/signUpConfirm")
	 public String signUpConfirm(@RequestParam Map<String, String> map){
	    //email, authKey 가 일치할경우 authStatus 업데이트
	    memberService.updateAuthStatus(map);
	    
	    return "redirect:/";
	}
	@GetMapping("/loginForm")
	public ModelAndView getLoginForm(HttpSession session, ModelAndView mav) {
		//세션에 로그인 값이 있으면 들어 갈 수 없도록 해야함.. 그래서 인덱스로 리다이렉팅
		if(session.getAttribute("member")!=null) {
			mav.setViewName("redirect:/");
		} else {
			// RSA 키 생성
		    PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
		    if (key != null) { // 기존 key 파기
		        session.removeAttribute("RSAprivateKey");
		    }
	    	RSA rsa = rsaUtil.createRSA();
	    	mav.addObject("modulus", rsa.getModulus());
	    	mav.addObject("exponent", rsa.getExponent());
	    	session.setAttribute("RSAprivateKey", rsa.getPrivateKey());
	    	mav.setViewName("member/loginForm");
		}
		return mav;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Member login(Member member, HttpSession session, RedirectAttributes ra) throws Exception{
		//개인키 취득
		PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
		if(key==null) {
			System.out.println("resultMsg 비정상 적인 접근 입니다.");
			return null;
		}
		
		//아이디/비밀번호 복호화
		String e_mail = rsaUtil.getDecryptText(key, member.getE_mail());
		String password = rsaUtil.getDecryptText(key, member.getPassword());
		
		//복호화된 평문을 재설정
		member.setE_mail(e_mail);
		member.setPassword(password);
		
		Member obj = memberService.select(member);
		
		if(obj != null) {
			session.setAttribute("member", obj);
			//session 에 저장된 개인키 초기화
			session.removeAttribute("RSAprivateKey");
		}
		return obj;
	}
	
	@GetMapping("/loginout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate(); //세션 무효화
		return "redirect:/";
	}
}
