package com.keyin.service;

import com.keyin.model.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ClientService clientService;

    public ClientServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCities() {
        City city = new City();
        city.setId(1);
        city.setName("New York");
        city.setState("NY");
        city.setPopulation(8419000);

        when(restTemplate.getForObject("http://localhost:8080/cities/", City[].class))
                .thenReturn(new City[]{city});

        List<City> cities = clientService.getAllCities();
        assertEquals(1, cities.size());
        assertEquals("New York", cities.get(0).getName());
    }

    @Test
    public void testGetAllAirports() {
        Airport airport = new Airport();
        airport.setId(1);
        airport.setName("JFK International");
        airport.setCode("JFK");

        when(restTemplate.getForObject("http://localhost:8080/airports", Airport[].class))
                .thenReturn(new Airport[]{airport});

        List<Airport> airports = clientService.getAllAirports();
        assertEquals(1, airports.size());
        assertEquals("JFK International", airports.get(0).getName());
    }

    @Test
    public void testGetAllAircraft() {
        Aircraft aircraft = new Aircraft();
        aircraft.setId(1L);
        aircraft.setType("Boeing 737");
        aircraft.setAirlineName("Delta Air Lines");
        aircraft.setNumberOfPassengers(160);

        when(restTemplate.getForObject("http://localhost:8080/aircraft", Aircraft[].class))
                .thenReturn(new Aircraft[]{aircraft});

        List<Aircraft> aircraftList = clientService.getAllAircrafts();
        assertEquals(1, aircraftList.size());
        assertEquals("Boeing 737", aircraftList.get(0).getType());
    }

    @Test
    public void testGetAllPassengers() {
        Passenger passenger = new Passenger();
        passenger.setId(1L);
        passenger.setFirstName("John");
        passenger.setLastName("Doe");
        passenger.setPhoneNumber("1234567890");

        when(restTemplate.getForObject("http://localhost:8080/passengers", Passenger[].class))
                .thenReturn(new Passenger[]{passenger});

        List<Passenger> passengers = clientService.getAllPassengers();
        assertEquals(1, passengers.size());
        assertEquals("John", passengers.get(0).getFirstName());
    }
}

