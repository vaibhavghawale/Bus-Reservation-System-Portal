package com.bookingportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingportal.models.Bus;

@Repository
public interface BusDao extends JpaRepository<Bus, Integer> {
	public List<Bus> findByBusType(String busType);
}
