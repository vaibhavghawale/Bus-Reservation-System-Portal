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

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.User;
import com.bookingportal.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		
		User savedUser= userService.createUser(user);
		
		return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/users")
	public  ResponseEntity<User> updateUser(@Valid @RequestBody User user,@RequestParam(required = false) String key ) {
		
		User updatedUser= userService.updateUser(user, key);
				
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/users/admin/{userId}")
	public  ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId ,@RequestParam(required = false) String key ) {
		
		User deletedUser= userService.deleteUser(userId, key);
				
		return new ResponseEntity<User>(deletedUser,HttpStatus.OK);
		
	}
	
	@GetMapping("/users/admin/{userId}")
	public  ResponseEntity<User> viewUser(@PathVariable("userId") Integer userId ,@RequestParam(required = false) String key ){
		
		User user= userService.viewUserById(userId, key);
				
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	
	@GetMapping("/users/admin")
	public  ResponseEntity<List<User>> viewAllUser(@RequestParam(required = false) String key )  {
		
		List<User> userList= userService.viewUsers(key);
				
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		
	}

}
