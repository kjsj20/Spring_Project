package com.jscompany.springproject.model.lecture.repository;

import java.util.List;

import com.jscompany.springproject.model.domain.lecture.Difficulty;

public interface DifficultyDAO {
	public List selectAll() throws Exception;
}
