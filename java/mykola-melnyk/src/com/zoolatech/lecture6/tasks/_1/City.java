package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;

public class City implements Comparator {
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

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

