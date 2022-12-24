package com.bookingportal.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.FeedBackException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.Bus;
import com.bookingportal.models.CurrentUserSession;
import com.bookingportal.models.Feedback;
import com.bookingportal.models.User;
import com.bookingportal.repositories.BusDao;
import com.bookingportal.repositories.FeedbackDao;
import com.bookingportal.repositories.UserDao;
import com.bookingportal.repositories.UserSessionDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedDao;
	
	@Autowired
	private UserDao userDao;


	@Autowired
	private BusDao busDao;
	
	@Autowired
	private UserSessionDao userSessionDao;


	
	@Override
	public Feedback addFeedBack(Feedback feedBack, Integer busId, String key) {
CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to give Feedback!");
		}
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
		
		Optional<Bus> busOptional = busDao.findById(busId);
		if (busOptional.isEmpty()) {

			throw new BusException("Bus is not present with Id: "+ busId);
		}


		feedBack.setBus(busOptional.get());
		feedBack.setUser(user);
		feedBack.setFeedbackDateTime(LocalDateTime.now());
		Feedback savedFeedback = feedDao.save(feedBack);

		return savedFeedback;
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback, String key) {
     CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to update Feedback!");
		}
		
		User user = userDao.findById(loggedInUser.getUserId()).orElseThrow(()-> new UserException("User not found!"));
		Optional<Feedback> opt = feedDao.findById(feedback.getFeedBackId());
		if (opt.isPresent()) {
			
			
			Feedback feedback2 = opt.get();
			
			Optional<Bus> busOptional = busDao.findById(feedback2.getBus().getBusId());
			if(!busOptional.isPresent()) throw new FeedBackException("Invalid bus details!");		
			feedback.setBus(busOptional.get());
			
			
			feedback.setUser(user);

			feedback.setFeedbackDateTime(LocalDateTime.now());

			return feedDao.save(feedback);
	}
		throw new FeedBackException("No feedback found!");

	}

	

	@Override
	public Feedback viewFeedback(Integer id){
		// TODO Auto-generated method stub
		Optional<Feedback> feedOptional = feedDao.findById(id);
		if (feedOptional.isPresent()) {

			return feedOptional.get();

		}
		throw new FeedBackException("No feedback found!");
		
	}

	@Override
	public List<Feedback> viewFeedbackAll() {
		// TODO Auto-generated method stub
		Optional<List<Feedback>> feedOptional = Optional.of(feedDao.findAll());
		if (feedOptional.isPresent()) {

			return feedOptional.get();

		}
		throw new FeedBackException("No feedbacks found!");
		
	}

	
}

