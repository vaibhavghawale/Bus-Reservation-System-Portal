package com.bookingportal.services;

import java.util.List;

import com.bookingportal.DTO.ReservationDTO;
import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.ReservationException;
import com.bookingportal.models.Reservation;

public interface ReservationService {
	
	public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException , BusException ;
		
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, BusException;
	
	public Reservation viewReservation(Integer reservationId,String key) throws ReservationException;
	
	public List<Reservation> viewAllReservation(String key)throws ReservationException;
	
	public List<Reservation> viewReservationByUser(String key) throws ReservationException;

//	Reservation addReservation(Reservation res) throws ReservationException;
	
}
