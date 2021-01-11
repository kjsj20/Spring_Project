package com.jscompany.springproject.controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.model.lecture.service.Lecture_SubCategoryService;
import com.jscompany.springproject.model.lecture.service.Lecture_TopCategoryService;

@Controller
public class LectureController {
	
	@Autowired
	Lecture_TopCategoryService lecture_TopCategoryService; 
	
	@Autowired
	Lecture_SubCategoryService lecture_SubCategoryService; 
	
	@GetMapping("/lecture/registForm")
	public ModelAndView getRegistForm(ModelAndView mav) throws Exception{
		List topList = lecture_TopCategoryService.selectAll();
		mav.addObject("topList",topList);
		mav.setViewName("lecture/regist");
		return mav;
	}
	
	@GetMapping("/lecture/getSubCategory")
	@ResponseBody
	public List getSubCategory(HttpServletRequest request) throws Exception {
		String subCategory_id =  request.getParameter("subCategory_id");
		System.out.println(subCategory_id);
		List subList = lecture_SubCategoryService.selectByTopId(Integer.parseInt(subCategory_id));
		return subList;
	}
}
