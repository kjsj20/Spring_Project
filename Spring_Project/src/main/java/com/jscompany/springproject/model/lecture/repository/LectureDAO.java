package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Lecture;

public interface LectureDAO {
	public List selectAllById(int member_id) throws Exception;
	public Lecture selectByLectureId(int lecture_id) throws Exception;
	public void insert(Lecture lecture) throws Exception;
	public int update(Lecture lecture) throws Exception;
	public int delete(int lecture_id) throws Exception;
}