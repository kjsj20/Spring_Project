package com.jscompany.springproject.controller.lecture;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.common.FileManager;
import com.jscompany.springproject.common.Pager;
import com.jscompany.springproject.model.domain.lecture.Lecture;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.lecture.service.LectureService;
import com.jscompany.springproject.model.lecture.service.Lecture_SubCategoryService;
import com.jscompany.springproject.model.lecture.service.Lecture_TopCategoryService;

@Controller
public class LectureController {
	
	@Autowired
	private Lecture_TopCategoryService lecture_TopCategoryService; 
	
	@Autowired
	private Lecture_SubCategoryService lecture_SubCategoryService; 
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private Pager pager;
	
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		fileManager.setSaveLogoImgDir(servletContext.getRealPath(fileManager.getSaveLogoImgDir()));
	}
	
	//registForm을 호출함과 동시에 탑 카테고리, 난이도 데이터를 가져와서 담음
	@GetMapping("/lecture/registForm")
	public ModelAndView getRegistForm(ModelAndView mav) throws Exception{
		List topList = lecture_TopCategoryService.selectAll();
		List diffList = lectureService.selectDiff();
		mav.addObject("topList",topList);
		mav.addObject("diffList", diffList);
		mav.setViewName("lecture/regist");
		return mav;
	}
	
	//서브 카테고리 가져오기
	@GetMapping("/lecture/getSubCategory")
	@ResponseBody
	public List getSubCategory(HttpServletRequest request) throws Exception {
		String subCategory_id =  request.getParameter("subCategory_id");
		List subList = lecture_SubCategoryService.selectByTopId(Integer.parseInt(subCategory_id));
		return subList;
	}
	
	//강의 등록 메서드
	@PostMapping("/lecture/regist")
	@ResponseBody
	public void lectureRegist(ModelAndView mav, Lecture lecture) throws Exception{
		lectureService.regist(fileManager, lecture);
	}
	
	//내 강의 조회
	@GetMapping("/lecture/list")
	public ModelAndView getLectureList(ModelAndView mav, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		if(session.getAttribute("member") != null) {
			Member member = (Member)session.getAttribute("member");
			List lectureList = lectureService.selectAllById(member.getMember_id());
			pager.init(request, lectureList);
			mav.addObject("pager", pager);
			mav.setViewName("/lecture/lectureList");
		} else {
			mav.setViewName("redirect:/loginForm");
		}
		return mav;
	}
}
