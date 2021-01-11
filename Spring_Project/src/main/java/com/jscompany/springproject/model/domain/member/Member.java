package com.jscompany.springproject.model.domain.member;
 
import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String e_mail;
	private String phone;
	private String birth_date;
	private String password;
	private String user_name;
	private int teacher_state_id;
	private String joindate;
	private String authkey;
	private int authstatus;
}
