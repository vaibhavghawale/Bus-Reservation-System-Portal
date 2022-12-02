package com.bookingportal.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.bookingportal.models.Bus;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data		//@Data Annotation use for creating a getter , setter , to string method its a Lambok dependency 
@NoArgsConstructor		//@NoArgConstruction use for creating a No argument constructor in spring application 
@AllArgsConstructor		//@AllArgConstruction use for creating a Parameterize argument constructor in spring application 
public class ReservationDTO {
	
	@NotNull(message = "Source of bus cannot be null... ")	//Source is Validate its mean we can not live blank or null.
	@NotBlank(message = "Source of bus cannot be blank... ")
	private String source;
	
	@NotNull(message = "Bus Destination cannot be null...") //destination is Validate its mean we can not live blank or null.
	@NotBlank(message = "Bus Destination cannot be blank...")
	private String destination;
	
	@NotNull		//Seat is Validate its mean we can not live null.
	private Integer noOfSeatsToBook;
	
	@NotNull  //Journey Date is Validate its mean we can not live null And also we can not enter a past date need to add a future date here.
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate journeyDate;
	
	private Bus busDTO;  
	
}
