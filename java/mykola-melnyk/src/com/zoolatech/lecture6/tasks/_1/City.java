package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;

public class City {
    private String name;
    private String country;
    private int population;

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public City getCity() {
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }

}

