package com.bookingportal;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableSwagger2
public class BusReservationSystemPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusReservationSystemPortalApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.bookingportal"))
				.build()
				.apiInfo(getApiInfo());
				
	}
	
	 private ApiInfo getApiInfo() {
	       return new ApiInfo(
	    		   "Bus Reservation Portal System",
	    		   "Team members :\n \"Vaibhav Ghavale\",\r\n"
	    		   + "\"Riya Negi\",\r\n"
	    		   + "\"Virendra Kumar\",\r\n"
	    		   + " \"Akash Kumar\",\r\n"
	    		   + "\"Gitanjali Makadi\"",

	    		   "1.0",
	    		   "Free to use",
	    		   new springfox.documentation.service.Contact("Happy Tour & Travels", "https://github.com/thecodervaibhav/Bus-Reservation-System-Portal", "vaibhavghawale007@gmail.com"),
	    		   "API License",
	    		   "https://github.com/thecodervaibhav/Bus-Reservation-System-Portal",
	    		  
	    		   Collections.emptyList());
	    		   
	    }

}
