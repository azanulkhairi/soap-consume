package com.company.jwt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;

//import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@SpringBootApplication
public class SoapConsumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumeApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(Test quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
			System.err.println(response.getCountry().getCapital());
			System.err.println(response.getCountry().getName());
		};
	}

}
