package com.jscompany.springproject.exception;

public class LectureRegistException extends RuntimeException{
	public LectureRegistException(String msg) {
			super(msg);
	}
	
	public LectureRegistException(String msg, Throwable e) {
		super(msg,e);
	} 
}
