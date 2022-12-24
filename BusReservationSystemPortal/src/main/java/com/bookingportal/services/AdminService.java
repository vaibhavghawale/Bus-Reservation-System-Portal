package com.bookingportal.services;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.models.Admin;

public interface AdminService {
	
    public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin,String key);

}
