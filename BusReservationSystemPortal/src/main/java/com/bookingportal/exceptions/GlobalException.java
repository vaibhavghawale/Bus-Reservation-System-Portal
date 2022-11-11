package com.bookingportal.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(ReservationException.class)
	public ResponseEntity<MyErrorDetail> reservationException(ReservationException reservationEx,WebRequest web){
		
		MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(),reservationEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> validatedException(MethodArgumentNotValidException validEx,WebRequest web){
		
		MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(),validEx.getMessage(),validEx.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> noHandler(NoHandlerFoundException nohandler,WebRequest web){
		
		MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(),nohandler.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> exception(Exception e,WebRequest web){ 
		
		MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(),e.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.EXPECTATION_FAILED);
	}
	
	//feedback
	@ExceptionHandler(FeedBackException.class)
	public ResponseEntity<MyErrorDetail> feedbackException(FeedBackException feedbackEx,WebRequest web){
		
	MyErrorDetail error = new MyErrorDetail(LocalDateTime.now(),feedbackEx.getMessage(), web.getDescription(false));
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	
}
	
