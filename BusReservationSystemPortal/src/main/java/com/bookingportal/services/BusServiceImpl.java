package com.bookingportal.services;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.BusException;
import com.bookingportal.models.Bus;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.models.Route;
import com.bookingportal.repositories.AdminSessionDao;
//import com.bookingportal.models.Route;
import com.bookingportal.repositories.BusDao;
import com.bookingportal.repositories.RouteDao;

@Service
public class BusServiceImpl implements BusService{
	
	private static final String BusType = null;

	@Autowired
	private BusDao busDao;
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private AdminSessionDao adminSessionDao;
	
	

	@Override
	public Bus addBus(Bus bus, String key)  {
    CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key...!");
		}
		
		Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
		
		if(route != null) {
			route.getBusList().add(bus);
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Please provide valid bus details..");
		
		
	}

	@Override
	public Bus updateBus(Bus bus, String key) {
CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key for update...!");
		}
		
		Optional<Bus> existingBusOpt=busDao.findById(bus.getBusId());
		
		if(existingBusOpt.isPresent()) {
			
			Bus existingBus = existingBusOpt.get();
			
			if(existingBus.getAvailableSeats()!=existingBus.getSeats()) throw new BusException("Bus details already exist..!");
			
			Route route=routeDao.findByRouteFromAndRouteTo(bus.getRouteFrom(), bus.getRouteTo());
			if(route == null) throw new BusException("Provided route in not valid...!");
			bus.setRoute(route);
			return busDao.save(bus);
		}
		else
			throw new BusException("Bus can't found with this busId : "+ bus.getBusId());
	}

	@Override
	public Bus deleteBus(Integer busId, String key)  {
    CurrentAdminSession loggedInAdmin= adminSessionDao.findByUuid(key);
		
		if(loggedInAdmin == null) {
			throw new AdminException("Please provide a valid key to delete bus...!");
		}
		
		Optional<Bus> bus=busDao.findById(busId);
		
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();			
			
			if(LocalDate.now().isBefore(existingBus.getBusJourneyDate()) && existingBus.getAvailableSeats()!=existingBus.getSeats())
				throw new BusException("Bus is having reservations, cannot be deleted...!");
			
			
			busDao.delete(existingBus);
			
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
	}

	@Override
	public Bus viewBus(Integer busId) throws BusException {
		Optional<Bus> bus=busDao.findById(busId);
		
		if(bus.isPresent()) {
			Bus existingBus = bus.get();
			return existingBus;
		}
		else
			throw new BusException("Bus doesn't exist with busId : "+busId);
	}

	@Override
	public List<Bus> viewBusByType(String BusType) {

		List<Bus> buses= busDao.findByBusType(BusType);
		if(buses.size()>0)
			return buses;
		else
			throw new BusException("There is no bus available in this portal...!");
	}

	@Override
	public List<Bus> viewAllBuses() {
		 List<Bus> listOfBusType = busDao.findAll();
			
			if(listOfBusType.size() >0)
				return listOfBusType;
			else
				throw new BusException("There is no bus of type "+ BusType);
	}


	
	

	
}
