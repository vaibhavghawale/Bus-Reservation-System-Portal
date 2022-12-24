package com.bookingportal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.FeedBackException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.Feedback;
import com.bookingportal.services.FeedbackService;


@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/feedback/user/{busid}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
												@PathVariable("busid") Integer busId,
												@RequestParam(required = false) String key){
		
		Feedback feedback1 = feedbackService.addFeedBack(feedback,busId,key);
		
		return new ResponseEntity<Feedback>(feedback1,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/feedback/user")
	public ResponseEntity<Feedback> updateFeedback(@Valid @RequestBody Feedback feedback,@RequestParam(required = false) String key) {
		
		Feedback feedback1 = feedbackService.updateFeedBack(feedback,key);
		
		return new ResponseEntity<Feedback>(feedback1,HttpStatus.ACCEPTED);
		
	}
	
	
//	viewFeedback
	
	@GetMapping("/feedback/{id}")
	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID)  {
		
		Feedback feedback1 = feedbackService.viewFeedback(ID);
		
		return new ResponseEntity<Feedback>(feedback1,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/feedback")
	public ResponseEntity<List<Feedback>> viewFeedbackAll() {
		
		List<Feedback> feedback1 =  feedbackService.viewFeedbackAll();
		
		return new ResponseEntity<List<Feedback>>(feedback1,HttpStatus.ACCEPTED);
		
	}
	
   
}
