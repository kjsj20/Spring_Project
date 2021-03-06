package com.jscompany.springproject.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.model.lecture.service.LectureService;
import com.jscompany.springproject.model.lecture.service.Lecture_TopCategoryService;

public class LectureDataAspect {
	@Autowired
	private Lecture_TopCategoryService lecture_TopCategoryService;
	
	@Autowired
	private LectureService lectureService;
	
	public Object getGlobalData(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result = null;
		HttpServletRequest request = null;
		
		//매개변수로부터 요청 객체 추출!!
		for(Object arg : joinPoint.getArgs()) {
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		String uri = request.getRequestURI(); //클라이언트의 요청 URI 스트링 정보
		
		if(uri.equals("/lecture/registForm")||uri.equals("/lecture/detail")||uri.equals("/lecture/sectionRegistFrom")||uri.equals("/course/list")||uri.equals("/course/listSub")) {
			List topList = lecture_TopCategoryService.selectAll();
			List diffList = lectureService.selectDiff();
			Object returnObj = joinPoint.proceed();
			ModelAndView mav = null;
			if(returnObj instanceof ModelAndView) {
				mav = (ModelAndView)returnObj;
				mav.addObject("topList", topList);
				mav.addObject("diffList", diffList);
				result = mav;
			}
		} else {
			result = joinPoint.proceed();
		}
		
		return result;
	}
}
