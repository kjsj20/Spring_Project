package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.model.lecture.repository.Lecture_TopCategoryDAO;

@Service
public class Lecture_TopCategoryServiceImpl implements Lecture_TopCategoryService{
	
	@Autowired
	private Lecture_TopCategoryDAO lecture_TopCategoryDAO;
	
	public List selectAll() throws Exception {
		return lecture_TopCategoryDAO.selectAll();
	}

}
