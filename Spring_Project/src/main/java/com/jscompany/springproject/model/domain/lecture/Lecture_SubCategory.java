package com.jscompany.springproject.model.domain.lecture;

import lombok.Data;

@Data
public class Lecture_SubCategory {
	private int lecture_subcategory_id;
	private int lecture_topcategory_id;
	private String lecture_subcategory_name;
	private int lecture_subcategory_rank;
}
