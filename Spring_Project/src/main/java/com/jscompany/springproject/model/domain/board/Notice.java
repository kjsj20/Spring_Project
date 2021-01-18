package com.jscompany.springproject.model.domain.board;

import lombok.Data;

@Data 
public class Notice {
	private int notice_id;
	private int member_id;
	private String writer;
	private String title;
	private String content;
	private String regdate; 
}
