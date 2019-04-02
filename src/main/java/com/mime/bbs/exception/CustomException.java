package com.mime.bbs.exception;
/**
 * CustomException 自定义异常类
 */
public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public CustomException(String message) {
		this.message=message;
	}
	
	public String getMessage() {
		return message;
	}
}
