package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
	
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public ExceptionResponse(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	private Date date;
	private String message;
	private String details;
	

}
