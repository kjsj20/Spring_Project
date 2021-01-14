package com.jscompany.springproject.model.domain.lecture;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Lecture {
	private int lecture_id;
	private int member_id;
	private int difficulty_id;
	private int lecture_subcategory_id;
	private String lecture_name;
	private String lecture_summary_content;
	private String lecture_detail_content;
	private int lecture_use_state;
	private int price; 
	private String logofile;
	private String registDate;
	
	//이미지를 자동으로 처리하는 객체, 이름을 html의 업로드 컴포넌트 파라미터명과 일치시켜야 자동으로 업로드처리함..
	private MultipartFile imgFile;
}
