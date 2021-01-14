package com.jscompany.springproject.model.domain.member;

import lombok.Data;

@Data
public class TeacherState {
	private int teacher_state_id;
	private String state; // 0 : student ,1 : teacher
}
