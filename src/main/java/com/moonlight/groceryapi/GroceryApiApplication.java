package com.moonlight.groceryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class GroceryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryApiApplication.class, args);
	}



}
