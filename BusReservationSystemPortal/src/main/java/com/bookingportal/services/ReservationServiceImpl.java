package com.bookingportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookingportal.DTO.ReservationDTO;
import com.bookingportal.exceptions.BusException;
import com.bookingportal.exceptions.ReservationException;
import com.bookingportal.models.Reservation;
import com.bookingportal.repositories.ReservationDao;


@Service

public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDao reservationDao;
	

	@Override
	public Reservation addReservation(ReservationDTO reservationDTO, String key)
			throws ReservationException, BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, BusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation viewReservation(Integer reservationId, String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewAllReservation(String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reservation> viewReservationByUser(String key) throws ReservationException {
		// TODO Auto-generated method stub
		return null;
	}

}
