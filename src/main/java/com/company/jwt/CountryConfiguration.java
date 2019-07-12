package com.company.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("io.spring.guides.gs_producing_web_service");
		return marshaller;
	}

	@Bean
	public WebServiceTemplate countryClient(Jaxb2Marshaller marshaller) {
		WebServiceTemplate client = new WebServiceTemplate();
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.setDefaultUri("http://localhost:5002/ws/countries");
		return client;
	}
}
