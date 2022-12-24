package com.bookingportal.exceptions;


// This a User Defined Exception which we created for use where we get a Reservation Exception.


public class ReservationException extends RuntimeException {

//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L; //Serialization ID is generated. 

	public ReservationException() {}
	
	public ReservationException(String message) {
		super(message);
	}
}
