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
	private MemberService memberService;

	@Autowired
	private MailSendService mss;

	@Autowired
	private RSAUtil rsaUtil;
	
	@PostMapping("/member/signup")
	@ResponseBody
	public int regist(Member member) throws Exception {

		int result = memberService.idCheck(member);

		if (result == 0) {
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
	public String signUpConfirm(@RequestParam Map<String, String> map) throws Exception {
		// email, authKey 가 일치할경우 authStatus 업데이트
		memberService.updateAuthStatus(map);

		return "redirect:/";
	}

	@GetMapping("/loginForm")
	public ModelAndView getLoginForm(HttpSession session, ModelAndView mav) {
		// 세션에 로그인 값이 있으면 들어 갈 수 없도록 해야함.. 그래서 인덱스로 리다이렉팅
		if (session.getAttribute("member") != null) {
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

	// RSA 방식 암호화 로그인
	@PostMapping("/login")
	@ResponseBody
	public Member login(Member member, HttpSession session, RedirectAttributes ra) throws Exception {
		// 개인키 취득
		PrivateKey key = (PrivateKey) session.getAttribute("RSAprivateKey");
		if (key == null) {
			System.out.println("resultMsg 비정상 적인 접근 입니다.");
			return null;
		}

		// 아이디/비밀번호 복호화
		String e_mail = rsaUtil.getDecryptText(key, member.getE_mail());
		String password = rsaUtil.getDecryptText(key, member.getPassword());

		// 복호화된 평문을 재설정
		member.setE_mail(e_mail);
		member.setPassword(password);

		Member obj = memberService.select(member);

		if (obj != null) {
			session.setAttribute("member", obj);
			// session 에 저장된 개인키 초기화
			session.removeAttribute("RSAprivateKey");
		}
		return obj;
	}

	// 로그아웃 하기
	@GetMapping("/loginout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate(); // 세션 무효화
		return "redirect:/";
	}

	// Id 찾기 폼으로 이동
	@GetMapping("/idSearchForm")
	public String idSearchForm() throws Exception {
		return "/member/idSearch";
	}

	// Id 찾기
	@GetMapping("/idSearch")
	@ResponseBody
	public String idSearch(HttpServletRequest request) throws Exception {
		String phone_number = request.getParameter("phone_number");
		String email = memberService.idSearch(phone_number);
		return email;
	}

	// Id 찾기 폼으로 이동
	@GetMapping("/passSearchForm")
	public String passSearchForm() throws Exception {
		return "/member/passSearch";
	}

	// Id 찾기
	@PostMapping("/passSearch")
	@ResponseBody
	public int passSearch(HttpServletRequest request, Member member) throws Exception {
		int result = memberService.passSearch(member);
		return result;
	}
	
	//마이페이지 폼으로 이동
	@GetMapping("/mypage")
	public String myPageForm() {
		return "/member/mypage";
	}
	
	//멤버 이름 수정
	@PostMapping("/mypage/nameEdit")
	@ResponseBody
	public int editMemberName(HttpServletRequest request, Member member) throws Exception{
		return memberService.nameUpdate(member);
	}
	
	//멤버 암호 수정
	@PostMapping("/mypage/passEdit")
	@ResponseBody
	public int editMemberPass(HttpServletRequest request, Member member) throws Exception{
		return memberService.passUpdate(member);
	}
	
	//멤버 휴대전화번호 수정
	@PostMapping("/mypage/phoneEdit")
	@ResponseBody
	public int editMemberEdit(HttpServletRequest request, Member member) throws Exception{
		return memberService.phoneUpdate(member);
	}
	
	//멤버 생년월일 수정
	@PostMapping("/mypage/birthEdit")
	@ResponseBody
	public int editMemberbirthEdit(HttpServletRequest request, Member member) throws Exception{
		return memberService.birthUpdate(member);
	}
	
	//회원탈퇴
	@GetMapping("/mypage/delMember")
	@ResponseBody
	public int delMember(HttpServletRequest  request) throws Exception{
		String member_id = request.getParameter("member_id");
		int result = memberService.delete(Integer.parseInt(member_id));
		if(result == 1) {
			request.getSession().invalidate();
		}
		return result;
	}
}
