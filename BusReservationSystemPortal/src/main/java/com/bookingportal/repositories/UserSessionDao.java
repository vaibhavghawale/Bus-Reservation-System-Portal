package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookingportal.models.CurrentUserSession;

public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String uuid);
}
