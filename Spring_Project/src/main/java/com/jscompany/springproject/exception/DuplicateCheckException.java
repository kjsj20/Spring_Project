package com.jscompany.springproject.exception;

public class DuplicateCheckException extends RuntimeException{
	public DuplicateCheckException(String msg) {
		super(msg);
	}
	public DuplicateCheckException(String msg, Throwable e) {
		super(msg, e);
	}
}
