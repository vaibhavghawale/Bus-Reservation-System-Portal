package com.bookingportal.services;

import java.util.List;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.User;

public interface UserService {

public User createUser(User user);
	
	public User updateUser(User user,String key);
	
	public User deleteUser(Integer userId,String key);
	
	public User viewUserById(Integer userId, String key);
	
	public List<User> viewUsers(String key); 
}
