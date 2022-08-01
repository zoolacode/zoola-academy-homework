package com.zoolatech.lecture6.tasks._1;

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

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return country +" has city " + name +
                " with population " + population;
    }
}
