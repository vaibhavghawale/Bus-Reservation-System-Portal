package com.bookingportal.services;

import java.util.List;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.RouteException;
import com.bookingportal.models.Route;



public interface RouteService {
	
	
    public Route addRoute(Route route,String key);
	public Route updateRoute(Route route,String key) ; 
	public Route deleteRoute(int routeId,String key) ;
	public Route viewRoute(int routeId) ;
	public List<Route> viewAllRoute() ;
}
