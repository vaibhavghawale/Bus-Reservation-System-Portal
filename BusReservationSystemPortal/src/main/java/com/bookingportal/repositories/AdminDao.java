package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingportal.models.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByMobileNumber(String mobileNumber);
}
