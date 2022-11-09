package com.bookingportal.models;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer busId;
      
     @NotNull(message = "Bus Name not be null..!")
     @NotNull(message = "Bus Name not be blank..!")
	 private String busName;
     
     @NotNull(message = "Driver Name not be null..!")
     @NotNull(message = "Driver Bus Name not be blank..!") 
	 private String DriverName;
     
     @NotNull(message = "Bus Type not be null..!")
	 private String busType;
     
     @NotNull(message = "Start point not be null..!")
     @NotNull(message = "Start point not be blank..!")
	 private String routeFrom;
     

     @NotNull(message = "End point not be null..!")
     @NotNull(message = "End point not be blank..!")
	 private String routeTo;
     
     @NotNull(message = "Bus journey data cannot null..!")
	 private LocalTime arrivalIime;
     
     @NotNull(message = "Departure Time  cannot null..!")
	 private LocalDate departureTime;
	 
    @NotNull(message = "Seats not be blank..!")
	 private Integer seats;
    @NotNull(message = "Seats not be blank..!")
	 private Integer availableSeats;
    
//    @OneToMany
//    private Route route;
    
    
    
	 
	
	
}
