package com.zoolatech.lecture6.tasks._1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class City {
    private final String name;
    private final String country;
    private final int population;

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public City(String name, String country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public static boolean isPopulationBigger(List<City> cities, int population) {
        return cities.stream()
                .allMatch(city -> city.population > population);
    }

    public static Optional<City> mostPopulousCity(List<City> cities, String country) {
        return cities.stream()
                .filter(city -> city.country.equals(country))
                .max(Comparator.comparingInt(City::getPopulation));
    }

    public static Map<String, City> toMap(List<City> cities) {
        return cities.stream()
                .collect(Collectors.toMap(City::getName, Function.identity(), (prev, next) -> next));
    }

    @Override
    public String toString() {
        return "\nname: '" + name + '\'' +
                "\ncountry: '" + country + '\'' +
                "\npopulation: " + population;
    }
}
