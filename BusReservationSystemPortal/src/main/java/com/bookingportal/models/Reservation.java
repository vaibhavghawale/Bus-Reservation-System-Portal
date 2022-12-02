package com.bookingportal.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




              //----------------- This is a Bean Class where we get a all variable which we need in Reservation part-------------------------------------//

//----------- Here we need to Encapsulate all the data member and data method in single unit for use out side just create getter and seeter ----------------------// 

@Entity										// Its Bean class so have to annotated with the @Entity  
@Data									    //Lambok for creating setter and getter method.
@NoArgsConstructor						    //No argument constructor create using annonatation
@AllArgsConstructor						    //parameterize argument constructor create using annonatation
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservationId;
	private String reservationStatus;
	
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private String source;
	private String destination;
	private LocalDate journeyDate;
	private Integer noOfSeatsBooked;
	private Integer fare;
	
	//it is UniDirectional relationship between reservation to bus
	//RESERVATION --------------------> BUS (MANY TO ONE)
	
	@ManyToOne
	private Bus bus;
	
	//it is bidirectional relationship between reservation to use
	//RESERVATION <----------------------> USER (MANY TO ONE)
	
	@ManyToOne
	private User user;
	
	
}
