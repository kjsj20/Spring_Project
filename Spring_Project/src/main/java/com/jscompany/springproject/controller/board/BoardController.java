package com.jscompany.springproject.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/board/notice")
	public String getNoticeForm() {
		
		return "board/notice";
	}
}
