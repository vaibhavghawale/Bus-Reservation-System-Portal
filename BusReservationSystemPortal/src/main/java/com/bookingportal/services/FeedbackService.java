package com.bookingportal.services;

import java.util.List;

import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.FeedBackException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.Feedback;


public interface FeedbackService {
		
	public Feedback addFeedBack(Feedback feedBack,Integer busId,String key);
	
	public Feedback updateFeedBack(Feedback feedback,String key);
	


	public Feedback viewFeedback(Integer id);

	public List<Feedback> viewFeedbackAll() ;
	
}
