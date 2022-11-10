package com.bookingportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bookingportal.models.Reservation;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

}
