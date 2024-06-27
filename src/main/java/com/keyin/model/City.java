package com.keyin.model;

import java.util.ArrayList;
import java.util.List;

public class City {
        private Integer id;
        private String name;
        private String state;
        private int population;
        private List<Airport> airports = new ArrayList<>();

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public List<Airport> getAirports() {
            return airports;
        }

        public void setAirports(List<Airport> airports) {
            this.airports = airports;
        }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
