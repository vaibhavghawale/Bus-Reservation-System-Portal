package com.bookingportal.services;

import com.bookingportal.DTO.AdminLoginDTO;
import com.bookingportal.exceptions.LoginException;
import com.bookingportal.models.CurrentAdminSession;

public interface AdminLoginService {

	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto);

	public String logOutFromAdminAccount(String key);
}
