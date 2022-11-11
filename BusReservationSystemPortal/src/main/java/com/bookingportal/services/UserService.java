package com.bookingportal.services;

import java.util.List;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.User;

public interface UserService {

public User createUser(User user)throws UserException;
	
	public User updateUser(User user,String key)throws UserException;
	
	public User deleteUser(Integer userId,String key) throws UserException, AdminException;
	
	public User viewUserById(Integer userId, String key) throws UserException, AdminException;
	
	public List<User> viewUsers(String key) throws UserException, AdminException; 
}
