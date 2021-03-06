package com.jscompany.springproject.controller.lecture;

import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.common.FileManager;
import com.jscompany.springproject.common.Pager;
import com.jscompany.springproject.model.domain.lecture.Lecture;
import com.jscompany.springproject.model.domain.lecture.Section;
import com.jscompany.springproject.model.domain.lecture.Section_detail;
import com.jscompany.springproject.model.domain.member.Member;
import com.jscompany.springproject.model.lecture.service.LectureService;
import com.jscompany.springproject.model.lecture.service.Lecture_SubCategoryService;
import com.jscompany.springproject.model.lecture.service.SectionService;

@Controller
public class LectureController implements ServletContextAware{
	private static final Logger logger=LoggerFactory.getLogger(LectureController.class);
	@Autowired
	private Lecture_SubCategoryService lecture_SubCategoryService; 
	
	@Autowired
	private LectureService lectureService;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private Pager pager;
	
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		fileManager.setSaveLogoImgDir(servletContext.getRealPath(fileManager.getSaveLogoImgDir()));
	}
	
	//registForm을 호출함과 동시에 탑 카테고리, 난이도 데이터를 가져와서 담음
	@GetMapping("/lecture/registForm")
	public ModelAndView getRegistForm(ModelAndView mav, HttpServletRequest request) throws Exception{
		mav.setViewName("lecture/regist");
		return mav;
	}
	
	//서브 카테고리 가져오기
	@GetMapping("/lecture/getSubCategory")
	@ResponseBody
	public List getSubCategory(HttpServletRequest request) throws Exception {
		String topCategory_id =  request.getParameter("topCategory_id");
		List subList = lecture_SubCategoryService.selectByTopId(Integer.parseInt(topCategory_id));
		return subList;
	}
	
	//강의 등록 메서드
	@PostMapping("/lecture/regist")
	@ResponseBody
	public void lectureRegist(ModelAndView mav, Lecture lecture, HttpServletRequest request) throws Exception{
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
	
	//강의 세부 정보 조회 
	@GetMapping("/lecture/detail")
	public ModelAndView getLectureDetail(ModelAndView mav, HttpServletRequest request) throws Exception{
		int lecture_id = Integer.parseInt(request.getParameter("lecture_id"));
		Lecture lecture = lectureService.selectByLectureId(lecture_id);
		mav.addObject("lecture",lecture);
		mav.setViewName("/lecture/lectureDetail");
		return mav;
	}
	
	//강의 데이터 수정 
	@PostMapping("/lecture/lectureEdit")
	@ResponseBody
	public int lectureEdit(Lecture lecture, HttpServletRequest request)throws Exception{
		int result = lectureService.update(fileManager,lecture);
		return result;
	}
	
	//강의 삭제
	@GetMapping("/lecture/delete")
	@ResponseBody
	public int lectureDel(HttpServletRequest request)throws Exception{
		String lecture_id =  request.getParameter("lecture_id");
		String currentPage =  request.getParameter("currentPage");
		lectureService.delete(Integer.parseInt(lecture_id));
		return Integer.parseInt(currentPage);
	}
	
	//섹션 추가폼으로 이동
	@GetMapping("/lecture/sectionRegistFrom")
	public ModelAndView sectionRegistForm(HttpServletRequest request, ModelAndView mav) {
		
		mav.setViewName("/lecture/section/sectionRegist");
		return mav;
	}
	
	//섹션 추가
	@PostMapping("/lecture/sectionRegist")
	@ResponseBody
	public void sectionRegist(@RequestParam(value="sectionList") List<String> sectionList, 
										@RequestParam(value="classList") List<String> classList,
										@RequestParam(value="urlList") List<String> urlList,
										@RequestParam(value="countList") List<Integer> countList,
										HttpServletRequest request, Section section, Section_detail section_detail) throws Exception{
		String lecture_id = request.getParameter("lecture_id");
		section.setLecture_id(Integer.parseInt(lecture_id));
		sectionService.regist(section, section_detail, classList, urlList, countList , sectionList);
		
		logger.debug("리스트 내용 : "+ sectionList);
		logger.debug("수업 내용 : "+ classList);
		logger.debug("url 내용 : "+ urlList);
		logger.debug("갯수 내용 : "+ countList);
	}
	
	//강의 조회폼 
	@GetMapping("/course/listForm")
	public ModelAndView getCourseForm(ModelAndView mav, HttpServletRequest request) {
		mav.setViewName("lecture/course/courselist");
		return mav;
	}
	
	//강의 조회
	@GetMapping("/course/list")
	public ModelAndView getCourse(ModelAndView mav, HttpServletRequest request) throws Exception{
			String topcategory_id = request.getParameter("topcategory_id");
			List lectureList = lectureService.selectByTopId(Integer.parseInt(topcategory_id));
			List subList = lecture_SubCategoryService.selectByTopId(Integer.parseInt(topcategory_id));
			mav.addObject("lectureList", lectureList);
			mav.addObject("subList", subList);
			mav.setViewName("lecture/course/courselist");
			return mav;
	}
	
	//강의 조회
	@GetMapping("/course/listSub")
	public ModelAndView getSubCourse(ModelAndView mav, HttpServletRequest request) throws Exception{
			String topcategory_id = request.getParameter("topcategory_id");
			String subcategory_id = request.getParameter("subcategory_id");
			List subList = lecture_SubCategoryService.selectByTopId(Integer.parseInt(topcategory_id));
			List lectureList = lectureService.selectSubList(Integer.parseInt(subcategory_id));
			
			mav.addObject("lectureList", lectureList);
			mav.addObject("subList", subList);
			mav.setViewName("lecture/course/courselist");
			return mav;
	}
	
	//강의 조회폼 
	@GetMapping("/course/detail")
	public ModelAndView getCourseDetailForm(ModelAndView mav, HttpServletRequest request) throws Exception{
		int lecture_id = Integer.parseInt(request.getParameter("lecture_id"));
		Lecture lecture = lectureService.selectByLectureId(lecture_id);
		List sectionList = sectionService.selectBylectureID(lecture_id); 
		List sectionDetailListList = sectionService.selectBySectionId(sectionList);
		mav.addObject("lecture",lecture);
		mav.addObject("sectionList",sectionList);
		mav.addObject("sectionDetailListList", sectionDetailListList);
		mav.setViewName("lecture/course/course_detail");
		return mav;
	}
	
	//내 강의 리스트 보기
	@GetMapping("/mycourselist")
	public ModelAndView getMyLecture(ModelAndView mav, HttpServletRequest request, int member_id) throws Exception{
		List lectureList = lectureService.selectByMemberId(member_id);
		mav.addObject("lectureList", lectureList);
		mav.setViewName("member/mycourselist");
		return mav;
	}
	
	@GetMapping("/lectureview")
	public  ModelAndView lectureViewForm(ModelAndView mav, HttpServletRequest request, int lecture_id) throws Exception{
		mav.setViewName("/lecture/lectureview");
		List sectionList = sectionService.selectBylectureID(lecture_id); 
		List sectionDetailListList = sectionService.selectBySectionId(sectionList);
		mav.addObject("sectionList",sectionList);
		mav.addObject("sectionDetailListList", sectionDetailListList);
		return mav;
	}
}
