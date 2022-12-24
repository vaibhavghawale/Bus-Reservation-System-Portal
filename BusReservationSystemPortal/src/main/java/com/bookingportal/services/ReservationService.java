package com.bookingportal.services;

import java.util.List;

import com.bookingportal.DTO.ReservationDTO;
import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.ReservationException;
import com.bookingportal.exceptions.UserException;
import com.bookingportal.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key);
	
	public Reservation deleteReservation(Integer reservationId, String key) ;
	
	public Reservation viewReservation(Integer reservationId,String key);
	
	public List<Reservation> viewAllReservation(String key);
	
	public List<Reservation> viewReservationByUser(String key);
	
}
