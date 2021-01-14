package com.jscompany.springproject.model.lecture.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscompany.springproject.common.FileManager;
import com.jscompany.springproject.model.domain.lecture.Lecture;
import com.jscompany.springproject.model.lecture.repository.DifficultyDAO;
import com.jscompany.springproject.model.lecture.repository.LectureDAO;

@Service
public class LectureServiceImpl implements LectureService{
	
	@Autowired
	private LectureDAO lectureDAO;
	 
	@Autowired
	private DifficultyDAO difficultyDAO;
	
	public List selectAllById(int member_id) throws Exception {
		return lectureDAO.selectAllById(member_id);
	}

	public Lecture selectByLectureId(int lecture_id) throws Exception {
		return lectureDAO.selectByLectureId(lecture_id);
	}
	
	public void regist(FileManager fileManager,Lecture lecture) throws Exception{
		String ext = fileManager.getExtend(lecture.getImgFile().getOriginalFilename());
		lecture.setLogofile(ext);
		lectureDAO.insert(lecture);
		
		//로고이미지 업로드 
		String logoImg = lecture.getLecture_id() + "." + fileManager.getExtend(lecture.getImgFile().getOriginalFilename());
		fileManager.saveFile(fileManager.getSaveLogoImgDir() + File.separator + logoImg, lecture.getImgFile());
	}
	
	
	//난이도 DAO에 난이도 테이블 select 요청
	public List selectDiff() throws Exception {
		return difficultyDAO.selectAll();  
	}

	public int update(FileManager fileManager,Lecture lecture) throws Exception {
		String ext = fileManager.getExtend(lecture.getImgFile().getOriginalFilename());
		lecture.setLogofile(ext);
		int result = lectureDAO.update(lecture);
		
		//로고이미지 업로드 
		String logoImg = lecture.getLecture_id() + "." + fileManager.getExtend(lecture.getImgFile().getOriginalFilename());
		fileManager.saveFile(fileManager.getSaveLogoImgDir() + File.separator + logoImg, lecture.getImgFile());
		
		return result;
	}
	
	//강의 삭제
	public int delete(int lecture_id) throws Exception {
		return lectureDAO.delete(lecture_id);
	}

}