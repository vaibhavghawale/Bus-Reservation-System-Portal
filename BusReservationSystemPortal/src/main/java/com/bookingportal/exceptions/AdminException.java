package com.bookingportal.exceptions;

public class AdminException extends RuntimeException{

    public AdminException() {
		super();
	}
    
    
	public AdminException(String message) {
		super(message);
	}
}
