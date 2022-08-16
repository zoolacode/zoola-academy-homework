package com.zoolatech.lecture6.tasks._1;

import java.util.Objects;

public record City(String name, String country, int population) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return population == city.population
                && name.equals(city.name)
                && country.equals(city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, population);
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
