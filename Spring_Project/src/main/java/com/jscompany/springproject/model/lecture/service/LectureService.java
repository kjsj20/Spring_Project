package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import com.jscompany.springproject.common.FileManager;
import com.jscompany.springproject.model.domain.lecture.Lecture;

public interface LectureService {
	public List selectAllById(int member_id) throws Exception;
	public Lecture selectByLectureId(int lecture_id) throws Exception;
	public void regist(FileManager fileManager, Lecture lecture) throws Exception;
	public List selectDiff() throws Exception;
	public int update(FileManager fileManager,Lecture lecture) throws Exception;
	public int delete(int lecture_id) throws Exception;
	public List selectByTopId(int topcategory_id) throws Exception;
	public List selectSubList(int subcategory_id) throws Exception;
	public List selectByMemberId(int member_id) throws Exception;
}
