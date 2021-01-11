package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

public interface Lecture_SubCategoryDAO {
	public List selectByTopId(int lecture_topcategory_id) throws Exception;
}
