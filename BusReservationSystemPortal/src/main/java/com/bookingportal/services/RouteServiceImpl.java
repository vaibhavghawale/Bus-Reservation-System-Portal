package com.bookingportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookingportal.exceptions.RouteException;
import com.bookingportal.models.Route;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class RouteServiceImpl  implements RouteService{

	@Override
	public Route addRoute(Route route, String key) throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route updateRoute(Route route, String key) throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route deleteRoute(int routeId, String key) throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route viewRoute(int routeId) throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> viewAllRoute() throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

}
