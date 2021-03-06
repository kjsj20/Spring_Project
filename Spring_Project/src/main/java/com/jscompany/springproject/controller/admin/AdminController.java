package com.jscompany.springproject.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.common.Pager;
import com.jscompany.springproject.model.member.service.MemberService;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private Pager pager;
	
	@GetMapping("/admin/list")
	public ModelAndView getMemberList(ModelAndView mav,HttpServletRequest request) throws Exception{
		List memberList = memberService.selectAll();
		pager.init(request, memberList);
		mav.addObject("pager", pager);
		mav.setViewName("admin/list");
		return mav;
	}
	
	@GetMapping("/admin/delMember")
	@ResponseBody
	public int delMember(HttpServletRequest  request) throws Exception{
		String member_id = request.getParameter("member_id");
		String currentPage = request.getParameter("currentPage");
		
		memberService.delete(Integer.parseInt(member_id));
		
		return Integer.parseInt(currentPage);
	}
}
