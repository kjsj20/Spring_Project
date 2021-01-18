package com.jscompany.springproject.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jscompany.springproject.common.Pager;
import com.jscompany.springproject.model.board.service.NoticeService;
import com.jscompany.springproject.model.board.service.QnaCommentService;
import com.jscompany.springproject.model.board.service.QnaService;
import com.jscompany.springproject.model.domain.board.Notice;
import com.jscompany.springproject.model.domain.board.Qna;
import com.jscompany.springproject.model.domain.board.Qna_Comment;

@Controller
public class BoardController {
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private QnaCommentService qnaCommentService; 
	
	@Autowired
	private Pager pager;
	
	//notice
	@GetMapping("/board/notice")
	public ModelAndView getNoticeForm(ModelAndView mav, HttpServletRequest request) throws Exception{
		List noticeList = noticeService.select();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("board/notice");
		return mav;
	}
	
	@GetMapping("/board/notice_detail")
	public ModelAndView getNoticeDetailForm(ModelAndView mav, int notice_id) throws Exception{
		Notice notice = noticeService.selectById(notice_id);
		mav.addObject("notice", notice);
		mav.setViewName("board/notice_detail");
		return mav;
	}
	
	@GetMapping("/board/notice_registForm")
	public String getNoticeRegistForm() {
		return "board/notice_registForm";
	}
	
	@PostMapping("/board/noticeRegist")
	@ResponseBody
	public int registNotice(Notice notice) throws Exception{
		int result = noticeService.registNotice(notice);
		return result;
	}
	
	@PostMapping("/board/noticeEdit")
	@ResponseBody
	public int editNotice(Notice notice) throws Exception{
		int result = noticeService.update(notice);
		return result;
	}
	
	@GetMapping("/board/noticeDel")
	@ResponseBody
	public int delNotice(int notice_id) throws Exception{
		int result = noticeService.delete(notice_id);
		return result;
	}
	
	//qna
	@GetMapping("/board/qna")
	public ModelAndView getQnaForm(ModelAndView mav, HttpServletRequest request) throws Exception{
		List qnaList = qnaService.select();
		pager.init(request, qnaList);
		mav.addObject("pager",pager);
		mav.setViewName("board/qna");
		return mav;
	}
	
	@GetMapping("/board/qna_detail")
	public ModelAndView getQnaDetailForm(ModelAndView mav, int qna_id) throws Exception{
		Qna qna = qnaService.selectById(qna_id);
		List cmmtList = qnaCommentService.selectCmmt(qna_id);
		mav.addObject("qna", qna);
		mav.addObject("cmmtList",cmmtList);
		mav.setViewName("board/qna_detail");
		return mav;
	}
	
	@GetMapping("/board/qna_registForm")
	public String getQnaRegistForm() {
		return "board/qna_registForm";
	}
	
	@PostMapping("/board/qnaRegist")
	@ResponseBody
	public int registQna(Qna qna) throws Exception{
		int result = qnaService.registQna(qna);
		return result;
	}
	
	@PostMapping("/board/qnaEdit")
	@ResponseBody
	public int editQna(Qna qna) throws Exception{
		int result = qnaService.update(qna);
		return result;
	}
	
	@GetMapping("/board/qnaDel")
	@ResponseBody
	public int delQna(int qna_id) throws Exception{
		int result = qnaService.delete(qna_id);
		return result;
	}
	
	@PostMapping("/board/cmmtRegist")
	@ResponseBody
	public List registCmmt(Qna_Comment qna_Comment) throws Exception{
		int result = qnaCommentService.regist(qna_Comment);
		List cmmtList = qnaCommentService.selectCmmt(qna_Comment.getQna_id());
		return cmmtList;
	}
	
	@GetMapping("/board/cmmtDel")
	@ResponseBody
	public List registCmmt(int qna_comment_id, int qna_id) throws Exception{
		int result = qnaCommentService.delete(qna_comment_id);
		List cmmtList = qnaCommentService.selectCmmt(qna_id);
		return cmmtList;
	}
}
