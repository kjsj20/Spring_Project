package com.jscompany.springproject.controller.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	 public String signUpConfirm(@RequestParam Map<String, String> map){
	    //email, authKey 가 일치할경우 authStatus 업데이트
	    memberService.updateAuthStatus(map);
	    
	    return "redirect:/";
	}
	@GetMapping("/loginForm")
	public ModelAndView getLoginForm(ModelAndView mav) {
		mav.setViewName("member/loginForm");
		return mav;
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Member login(Member member, HttpServletRequest request) throws Exception{
		Member obj = memberService.select(member);
		System.out.println(obj);
		if(obj != null) {
			HttpSession session = request.getSession();
			System.out.println(session);
			session.setAttribute("member", obj);			
		}
		return obj;
	}
	
	@GetMapping("/loginout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate(); //세션 무효화
		return "redirect:/";
	}
}
