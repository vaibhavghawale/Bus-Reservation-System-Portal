package com.bookingportal.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookingportal.DTO.AdminLoginDTO;
import com.bookingportal.exceptions.LoginException;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.services.AdminLoginService;

@RestController
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLogin;
	
	@PostMapping("/login/admin")
	public ResponseEntity<CurrentAdminSession> logInAdmin(@Valid @RequestBody AdminLoginDTO dto) {
		
		CurrentAdminSession result = adminLogin.logIntoAdminAccount(dto);
		
		return new ResponseEntity<CurrentAdminSession>(result,HttpStatus.ACCEPTED );
		
	}
	
	@PostMapping("/logout/admin")
	public String logoutAdmin(@RequestParam(required = false) String key) {
		
		return adminLogin.logOutFromAdminAccount(key);
		
	}
}
