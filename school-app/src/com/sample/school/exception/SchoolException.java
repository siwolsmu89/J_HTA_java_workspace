package com.sample.school.exception;

public class SchoolException extends RuntimeException {
	
	private String errorCode;
	
	public SchoolException() {
		
	}
	
	public SchoolException(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
