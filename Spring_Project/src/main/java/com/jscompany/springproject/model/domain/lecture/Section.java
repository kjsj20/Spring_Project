package com.jscompany.springproject.model.domain.lecture;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Section {
	private int section_id;
	private int lecture_id;
	private String section_name;
}
