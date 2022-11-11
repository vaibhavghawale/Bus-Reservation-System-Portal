package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingportal.models.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findByMobileNumber(String mobileNumber);
}
