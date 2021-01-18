package com.jscompany.springproject.model.domain.board;

import lombok.Data;

@Data
public class Qna_Comment {
	private int qna_comment_id;
	private int member_id;
	private int qna_id;
	private String cmmt_content;
	private String regdate; 
	private String user_name;
}
