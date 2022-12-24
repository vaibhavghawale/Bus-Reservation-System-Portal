package com.bookingportal.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.DTO.UserLoginDTO;
import com.bookingportal.exceptions.LoginException;
import com.bookingportal.models.CurrentUserSession;
import com.bookingportal.models.User;
import com.bookingportal.repositories.UserDao;
import com.bookingportal.repositories.UserSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;

	@Override
	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto){

		User existingUser= userDao.findByMobileNumber(dto.getMobileNumber());
		
		if(existingUser == null) throw new LoginException("This is not valid mobile number...!");
		
		
		Optional<CurrentUserSession> validUserSessionOpt =  userSessionDao.findById(existingUser.getUserId());
		
		
		if(validUserSessionOpt.isPresent()) {
			
			throw new LoginException("user already Log-In with this number..!"+validUserSessionOpt);
		}
		
		if(existingUser.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			
			userSessionDao.save(currentUserSession);

			return currentUserSession;
		}
		else
			throw new LoginException("Please Enter a valid password...!");
	}

	@Override
	public String logOutFromUserAccount(String key)  {
				
		CurrentUserSession validUserSession = userSessionDao.findByUuid(key);
		
		if(validUserSession == null) {
			throw new LoginException("user Not Logged In with this number"+validUserSession);
			
		}
		
		userSessionDao.delete(validUserSession);
		
		return "User Logged Out !";
	}
}
