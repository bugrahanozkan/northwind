package com.kodlamaio.northwind;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NorthwindApplication {
	
	@Bean
	public ModelMapper GetModulMopper() {
		return new ModelMapper();
		}
	public static void main(String[] args) {
		
		
		SpringApplication.run(NorthwindApplication.class, args);
	}

}
