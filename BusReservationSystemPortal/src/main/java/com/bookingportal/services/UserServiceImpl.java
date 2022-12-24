package com.bookingportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.models.CurrentUserSession;
import com.bookingportal.models.User;
import com.bookingportal.repositories.AdminSessionDao;
import com.bookingportal.repositories.UserDao;
import com.bookingportal.repositories.UserSessionDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDao userSessionDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Override
	public User createUser(User user){
		
		User existingUser= userDao.findByMobileNumber(user.getMobileNumber());
		
		if(existingUser != null) 
			throw new UserException("Mobile number is already existed, User cannot be created...!");
			
		
		return userDao.save(user);
	
	}
	@Override
	public User updateUser(User user, String key) {
		
		CurrentUserSession loggedInUser= userSessionDao.findByUuid(key);
		
		if(loggedInUser == null) {
			throw new UserException("Please enter valid key for updating user Details...!");
		}
		
		if(user.getUserId() == loggedInUser.getUserId()) {
			
			
			return userDao.save(user);
		}
		else
			throw new UserException("Invalid Admin Details, please login first...!");
	}
	
	
	@Override
	public User deleteUser(Integer userId, String key) {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please enter a valid key for delete user...!");
		}
		User user = userDao.findById(userId).orElseThrow(()-> new UserException("Invalid user Id!"));
		userDao.delete(user);
		return user;
		
		
	}
	@Override
	public User viewUserById(Integer userId, String key){

		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please enter valid key for view user Details...!");
		}
		
		User user = userDao.findById(userId).orElseThrow(()-> new UserException("Invalid user Id!"));
		return user;
	}
	
	@Override
	public List<User> viewUsers(String key){
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please enter valid key for view all user Detail...!");
		}
		
		List<User> userList = userDao.findAll();
		if(userList.isEmpty()) throw new UserException("No users found!");
		
		return userList;
	}
}
