package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.lecture.repository.Lecture_SubCategoryDAO;

@Service
public class Lecture_SubCategoryServiceImpl implements Lecture_SubCategoryService{
	
	@Autowired
	Lecture_SubCategoryDAO lecture_SubCategoryDAO;
	
	public List selectByTopId(int lecture_topcategory_id) throws Exception {
		return lecture_SubCategoryDAO.selectByTopId(lecture_topcategory_id);
	}

}
