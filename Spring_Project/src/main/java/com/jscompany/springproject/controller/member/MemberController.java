package com.jscompany.springproject.controller.member;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.exception.DuplicateCheckException;
import com.jscompany.springproject.model.domain.Member;
import com.jscompany.springproject.model.member.service.MailSendService;
import com.jscompany.springproject.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	private MailSendService mss;
	
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
	 public ModelAndView signUpConfirm(@RequestParam Map<String, String> map, ModelAndView mav){
	    //email, authKey 가 일치할경우 authStatus 업데이트
	    memberService.updateAuthStatus(map);
	    
	    mav.setViewName("index");
	    return mav;
	}
}
