package com.bookingportal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.bookingportal.exceptions.AdminException;
import com.bookingportal.exceptions.RouteException;
import com.bookingportal.models.Route;
import com.bookingportal.services.RouteService;


@RestController
public class RouteController {
	
	@Autowired
	private RouteService RouteS;
	
	@PostMapping("/route/admin")
	public ResponseEntity<Route> addNewRoute(@Valid @RequestBody Route route,@RequestParam(required = false) String  key) {
		
		Route newRout = RouteS.addRoute(route, key);
		return new ResponseEntity<>(newRout,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/route/admin/{routeId}")
	public ResponseEntity<Route> DeleteRoute(@PathVariable("routeId") Integer routeId,@RequestParam(required = false) String key)  {
		
		Route route = RouteS.deleteRoute(routeId,key);
		
		return new ResponseEntity<Route>(route,HttpStatus.GONE);
	}
	
	@GetMapping("/route/{routeId}")
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId") Integer routeId){
		
		Route route = RouteS.viewRoute(routeId);
		
		return new ResponseEntity<Route>(route,HttpStatus.OK);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes(){
		
		List<Route> routes = RouteS.viewAllRoute();
		
		return new ResponseEntity<List<Route>>(routes,HttpStatus.OK);
	}

}
