package com.keyin;

import com.keyin.model.Aircraft;
import com.keyin.model.Airport;
import com.keyin.model.City;
import com.keyin.model.Passenger;
import com.keyin.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
      RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(ClientService clientService) {
        return args -> {
            // Fetch all cities and print them
            List<City> cities = clientService.getAllCities();
            cities.forEach(city -> System.out.println(city.toString()));

//            // Fetch all airports and print them
//            List<Airport> airports = clientService.getAllAirports();
//            airports.forEach(airport -> System.out.println(airport.toString()));
//
//            // Fetch all aircraft and print them
//            List<Aircraft> aircrafts = clientService.getAllAircrafts();
//            aircrafts.forEach(aircraft -> System.out.println(aircraft.toString()));
//
//            // Fetch all passengers and print them
//            List<Passenger> passengers = clientService.getAllPassengers();
//            passengers.forEach(passenger -> System.out.println(passenger.toString()));


        };
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> factory.setPort(8081);
    }
}

