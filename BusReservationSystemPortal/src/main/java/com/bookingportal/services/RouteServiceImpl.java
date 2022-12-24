package com.bookingportal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.RouteException;
import com.bookingportal.models.Bus;
import com.bookingportal.models.CurrentAdminSession;
import com.bookingportal.models.Route;
import com.bookingportal.repositories.AdminDao;
import com.bookingportal.repositories.AdminSessionDao;
import com.bookingportal.repositories.BusDao;
import com.bookingportal.repositories.RouteDao;



@Service
public class RouteServiceImpl  implements RouteService{
    @Autowired
	private RouteDao roD;
    @Autowired
	private BusDao buD;
    @Autowired
	private AdminDao AdD;
    @Autowired
	private AdminSessionDao asD;
	
	
	
	@Override
	public Route addRoute(Route route, String key) {
     
		CurrentAdminSession logInAdmin = asD.findByUuid(key);
		if(logInAdmin==null) {
			throw new AdminException("This is not not valid key");
		}
		Route newroute = roD.findByRouteFromAndRouteTo(route.getRouteFrom(), route.getRouteTo());
		
		if(newroute !=null) {
			throw new RouteException("Route-"+newroute.getRouteFrom()+" to " + newroute.getRouteTo()+"present...!");
			
		}
         List<Bus> buses = new ArrayList<>();	
		
		if(route != null) {
			route.setBusList(buses);
			return roD.save(route);
		}else {
			throw new RouteException("this Route not presen...!");
		}
		
		
	}
	
	@Override
	public Route viewRoute(int routeId){
		
    Optional<Route> existedRoute=roD.findById(routeId);
		if(existedRoute.isPresent()) {
			return existedRoute.get();
		}
		else {
			throw new RouteException("There is no route present of routeId :" + routeId);
		}
	}

	@Override
	public Route updateRoute(Route route, String key) {
		CurrentAdminSession logInAdmin = asD.findByUuid(key);
		if(logInAdmin==null) {
			throw new AdminException("This is not not valid key");
		}
		
		Optional<Route> existingRoute =  roD.findById(route.getRouteId());
		if(existingRoute.isPresent()) {
			Route presentRoute = existingRoute.get();
			List<Bus> busliList = presentRoute.getBusList();
			if(!busliList.isEmpty()) {
				throw new RouteException("cannot update running route bus is already present");
				
				
			}
			else {
				return roD.save(route);
			}
			}else {
			throw new RouteException("Route is not present with this id"+route.getRouteId());	
			}
		
		
	
	}

	@Override
	public Route deleteRoute(int routeId, String key) {
		CurrentAdminSession logInAdmin = asD.findByUuid(key);
		if(logInAdmin==null) {
			throw new AdminException("This is not not valid key");
		}else {
			
			Optional<Route> route = roD.findById(routeId);
			
			if(route.isPresent()){
				Route existingRoute=route.get();
				roD.delete(existingRoute);
				return existingRoute;
			}else {
				throw new RouteException("There is no route of routeId : "+ routeId);
			}
			
		}
		
		
	}

	

	@Override
	public List<Route> viewAllRoute(){
     List<Route> routes=roD.findAll();
		if(routes.size()>0) {
			return routes;
		}
		else {
			throw new RouteException("There is no route available");
		}	
	}

}
