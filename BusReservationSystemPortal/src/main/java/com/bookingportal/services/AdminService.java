package com.bookingportal.services;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.models.Admin;

public interface AdminService {
	
    public Admin createAdmin(Admin admin)throws AdminException;
	
	public Admin updateAdmin(Admin admin,String key)throws AdminException;

}
