package com.example;

import com.example.consumingwebservice.wsdl.CountryClient;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient countryClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = countryClient.getCountry(country);
			System.out.println("Moneda : "+response.getCountry().getCurrency());
			System.out.println("Capital : "+response.getCountry().getCapital());
			System.out.println("Poblacion : "+response.getCountry().getPopulation());

		};
	}
}
