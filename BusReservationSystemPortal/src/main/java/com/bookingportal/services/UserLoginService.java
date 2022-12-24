package com.bookingportal.services;

import com.bookingportal.DTO.UserLoginDTO;
import com.bookingportal.exceptions.LoginException;
import com.bookingportal.models.CurrentUserSession;

public interface UserLoginService {

	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto);

	public String logOutFromUserAccount(String key);
}
