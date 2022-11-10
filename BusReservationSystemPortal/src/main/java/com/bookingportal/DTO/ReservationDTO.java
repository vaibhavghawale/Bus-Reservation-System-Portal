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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
	
	@NotNull(message = "Source of bus cannot be null... ")
	@NotBlank(message = "Source of bus cannot be blank... ")
	private String source;
	
	@NotNull(message = "Bus Destination cannot be null...")
	@NotBlank(message = "Bus Destination cannot be blank...")
	private String destination;
	
	@NotNull
	private Integer noOfSeatsToBook;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate journeyDate;
	
	private Bus busDTO;
	
}
