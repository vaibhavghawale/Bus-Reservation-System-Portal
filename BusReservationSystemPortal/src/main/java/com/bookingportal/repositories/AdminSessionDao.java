package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingportal.models.CurrentAdminSession;

public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{
	public  CurrentAdminSession findByUuid(String uuid);
}
