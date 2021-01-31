package com.jscompany.springproject.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.model.lecture.service.LectureService;

@Controller
public class MainController{
	
	@Autowired
	private LectureService lectureService;
	
	@GetMapping("/")
	public ModelAndView  main(ModelAndView mav) throws Exception{
		List lectureList = lectureService.selectMainList();
		mav.addObject("lectureList", lectureList);
		mav.setViewName("/index");
		return mav;
	}
}