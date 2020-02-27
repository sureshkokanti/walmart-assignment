package com.walmartassignment.exception;

public class ExceptionResponse {

	private String message;
	private String validUrl;
	private Integer statusCode;
	
	public ExceptionResponse() {
		super();
	}
	
	public ExceptionResponse(String message, String validUrl, Integer statusCode) {
		super();
		this.message = message;
		this.validUrl = validUrl;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValidUrl() {
		return validUrl;
	}

	public void setValidUrl(String validUrl) {
		this.validUrl = validUrl;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
}
