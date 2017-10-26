package com.santosh.fizzbuzz.errors;

import org.springframework.http.HttpStatus;

public class ApiError {
	
	private HttpStatus status;
	private String localizedMessage;
	private String error;
	
	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public String getError() {
		return error;
	}

	public ApiError(HttpStatus badRequest, String localizedMessage, String error) {
		// TODO Auto-generated constructor stub
		this.status=badRequest;
		this.localizedMessage=localizedMessage;
		this.error=error;
	}

	public HttpStatus getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}

}
