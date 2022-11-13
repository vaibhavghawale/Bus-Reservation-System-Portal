package com.bookingportal.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	private Integer driverRating;
	
	@Min(value=1, message="Rating must be in the range of 1-5")  
	@Max(value=5, message="Rating must be in the range of 1-5") 
	private Integer serviceRating;
	
	private Integer overallRating;
	
	private String comments;
	private LocalDateTime feedbackDateTime;
	
	
	//it is unidiractnal relationship between feedback and user 
	//USER -----> FEEDBACK 
	@OneToOne
	private User user;

	//it is unidiractnal relationship between feedback and BUS
	//BUS -----> FEEDBACK 
	@OneToOne
	private Bus bus;

	
	
}
