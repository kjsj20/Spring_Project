package com.jscompany.springproject.controller.lecture;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jscompany.springproject.model.lecture.service.MemberhavelectureService;

@Controller
public class MemberhavelectureController {
	
	@Autowired
	private MemberhavelectureService memberhavelectureService; 
	
	//강의 수강 신청
		@GetMapping("/course/regist")
		@ResponseBody
		public int courseRegist(HttpServletRequest request,  int member_id, int lecture_id) throws Exception {
			Map map = new HashMap();
			map.put("member_id", member_id);
			map.put("lecture_id", lecture_id);
			int result = 0;
			int alreadyVal = memberhavelectureService.selectByMemberLectureID(map);
			
			if(alreadyVal == 0) {
				result = memberhavelectureService.courseRegist(map);				
			} else {
				result = 2;
			}
			
			return result;
		}
}
