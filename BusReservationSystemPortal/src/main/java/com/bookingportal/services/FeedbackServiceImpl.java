package com.bookingportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exception.FeedBackException;
import com.bookingportal.models.Feedback;
import com.bookingportal.repositories.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedDao;
	
//	@Autowired
//	private UserDao userDao;
//
//	@Autowired
//	private BusDao busDao;
//	
//	@Autowired
//	private UserSessionDao userSessionDao;

	@Override
	public Feedback viewFeedback(Integer id) throws FeedBackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws FeedBackException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
