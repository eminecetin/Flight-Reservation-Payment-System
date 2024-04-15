package com.booking.flight.SystemOfFlightApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class SystemOfFlightApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemOfFlightApplication.class, args);
	}

}
