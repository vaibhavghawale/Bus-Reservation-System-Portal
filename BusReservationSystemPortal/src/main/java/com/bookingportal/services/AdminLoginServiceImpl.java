package com.bookingportal.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.DTO.AdminLoginDTO;
import com.bookingportal.exceptions.LoginException;
import com.bookingportal.models.Admin;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.repositories.AdminDao;
import com.bookingportal.repositories.AdminSessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto)  {

		Admin existingAdmin= adminDao.findByMobileNumber(dto.getMobileNumber());
		
		if(existingAdmin == null) throw new LoginException("This is not valid mobile number...!");
		
		
		Optional<CurrentAdminSession> validAdminSessionOpt =  adminSessionDao.findById(existingAdmin.getAdminId());
		
		
		if(validAdminSessionOpt.isPresent()) {
			
			throw new LoginException("Admin already Log-In with this number..!"+validAdminSessionOpt);
		}
		
		if(existingAdmin.getAdminPassword().equals(dto.getAdminPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(),key,LocalDateTime.now());
			
			adminSessionDao.save(currentAdminSession);

			return currentAdminSession;
		}
		else
			throw new LoginException("Please Enter a valid password!");
	}

	@Override
	public String logOutFromAdminAccount(String key) {

		CurrentAdminSession validAdminSession = adminSessionDao.findByUuid(key);
		
		if(validAdminSession == null) {
			throw new LoginException("Admin Not Logged In with this number"+validAdminSession);
			
		}
		
		adminSessionDao.delete(validAdminSession);
		
		return "Admin Logged Out Succesfully...!";
	}
}
