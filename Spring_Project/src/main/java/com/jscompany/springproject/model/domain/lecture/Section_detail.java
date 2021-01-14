package com.jscompany.springproject.model.domain.lecture;

import lombok.Data;

@Data
public class Section_detail {
	private int section_detail_id;
	private int section_id; 
	private String section_detail_name;
	private String section_lectureurl;
	private String section_lecturefilename;
}
