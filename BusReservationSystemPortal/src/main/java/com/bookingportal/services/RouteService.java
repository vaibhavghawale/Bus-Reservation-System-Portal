package com.bookingportal.services;

import com.bookingportal.exceptions.RouteException;
import com.bookingportal.models.Route;

import antlr.collections.List;

public interface RouteService {
	
	
    public Route addRoute(Route route,String key) throws RouteException;
	public Route updateRoute(Route route,String key) throws RouteException; 
	public Route deleteRoute(int routeId,String key) throws RouteException;
	public Route viewRoute(int routeId) throws RouteException;
	//public List<Route> viewAllRoute() throws RouteException;
}
