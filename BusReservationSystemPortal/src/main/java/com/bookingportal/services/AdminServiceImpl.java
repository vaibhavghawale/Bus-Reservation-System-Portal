package com.bookingportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.models.Admin;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.repositories.AdminDao;
import com.bookingportal.repositories.AdminSessionDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Override
	public Admin createAdmin(Admin admin) throws AdminException {
		
		Admin existingAdmin= adminDao.findByMobileNumber(admin.getMobileNumber());
		
		if(existingAdmin != null) 
			throw new AdminException("Admin already registered with this Mobile number!");
		
		return adminDao.save(admin);
	
	}
	
	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to update Admin Details!");
		}
		
		if(admin.getAdminId() == loggedInAdmin.getAdminId()) {
			
			return adminDao.save(admin);
		}
		else
			throw new AdminException("Invalid Admin Details! please login first.");
	}

}
