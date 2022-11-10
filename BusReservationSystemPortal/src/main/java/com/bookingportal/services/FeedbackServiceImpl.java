package com.bookingportal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.FeedBackException;
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

//	@Override
//	public Feedback addFeedBack(Feedback feedBack, Integer busId, String key) throws BusException, UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Feedback updateFeedBack(Feedback feedback, String key) throws FeedBackException, UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Feedback deleteFeedBack(Integer feedbackId, String key) throws FeedBackException, UserException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Feedback viewFeedback(Integer id) throws FeedBackException {
		// TODO Auto-generated method stub
		Optional<Feedback> fedOptional = feedDao.findById(id);
		if (fedOptional.isPresent()) {

			return fedOptional.get();

		}
		throw new FeedBackException("No feedback found!");
		
	}

	@Override
	public List<Feedback> viewFeedbackAll() throws FeedBackException {
		// TODO Auto-generated method stub
		Optional<List<Feedback>> fedOptional = Optional.of(feedDao.findAll());
		if (fedOptional.isPresent()) {

			return fedOptional.get();

		}
		throw new FeedBackException("No feedbacks found!");
		
	}


}

	

