package com.keyin.service;

import com.keyin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private RestTemplate restTemplate;

    private final String API_URL = "http://localhost:8080";

    public List<City> getAllCities() {
        return Arrays.asList(restTemplate.getForObject(API_URL + "/cities", City[].class));
    }

    public List<Airport> getAllAirports() {
        return Arrays.asList(restTemplate.getForObject(API_URL + "/airports", Airport[].class));
    }

    public List<Aircraft> getAllAircrafts() {
        return Arrays.asList(restTemplate.getForObject(API_URL + "/aircraft", Aircraft[].class));
    }

    public List<Passenger> getAllPassengers() {
        return Arrays.asList(restTemplate.getForObject(API_URL + "/passengers", Passenger[].class));
    }
}

