package com.bookingportal.services;

import java.util.List;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.BusException;
import com.bookingportal.models.Bus;

public interface BusService {


	public Bus addBus(Bus bus,String key) ;
	
	public Bus updateBus(Bus bus,String key);
	
	public Bus deleteBus(Integer busId,String key);
	
	public Bus viewBus(Integer busId);
	
	public List<Bus> viewBusByType(String BusType);
	
	public List<Bus> viewAllBuses();

}
