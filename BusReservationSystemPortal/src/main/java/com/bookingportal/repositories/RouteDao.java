package com.bookingportal.repositories;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookingportal.models.Route;

@Repository
public interface RouteDao extends JpaRepository<Route, Integer>{

	public Route findByRouteFromAndRouteTo(String from,String to);

}
