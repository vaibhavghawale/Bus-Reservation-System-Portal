package com.bookingportal.exceptions;

import java.time.LocalDateTime;

public class MyErrorDetail {

	private LocalDateTime time;
	private String message;
	private String description;
	
	
	
	public MyErrorDetail() {
		// TODO Auto-generated constructor stub
	}



	public MyErrorDetail(LocalDateTime time, String message, String description) {
		super();
		this.time = time;
		this.message = message;
		this.description = description;
	}



	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}


	
}
