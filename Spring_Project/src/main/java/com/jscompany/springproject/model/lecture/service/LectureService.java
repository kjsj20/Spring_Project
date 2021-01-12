package com.jscompany.springproject.model.lecture.service;

import java.util.List;

import com.jscompany.springproject.common.FileManager;
import com.jscompany.springproject.model.domain.lecture.Lecture;

public interface LectureService {
	public List selectAllById(int member_id) throws Exception;
	public Lecture selectByLectureId(Lecture lecture) throws Exception;
	public void regist(FileManager fileManager, Lecture lecture) throws Exception;
	public List selectDiff() throws Exception;
}
