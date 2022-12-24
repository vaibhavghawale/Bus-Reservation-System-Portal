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
	public Admin createAdmin(Admin admin){
		
		Admin existingAdmin= adminDao.findByMobileNumber(admin.getMobileNumber());
		
		if(existingAdmin != null) 
			throw new AdminException("Mobile number is already existed, admin cannot be created...!");
		
		return adminDao.save(admin);
	
	}
	
	@Override
	public Admin updateAdmin(Admin admin, String key) {
		
		CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please enter valid key for updating Admin Details...!");
		}
		
		if(admin.getAdminId() == loggedInAdmin.getAdminId()) {
			
			return adminDao.save(admin);
		}
		else
			throw new AdminException("Invalid Admin Details, please login first...!");
	}

}
