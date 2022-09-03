package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class City has the following properties: string name, string country, int population.
 * Create methods (all of them need to use Stream API)
 * 1)that accepts a list of cities and a value of a population, and returns true if all cities in the list have
 * the population bigger than a passed value
 * 2)that accepts a list of cities and a country name and returns a city with the biggest population for that country
 * 3)that accepts a list of cities and returns a map, where the key is the city name and and a value -
 * is a corresponding city object (note: the list might contain duplicates)
 */

public class Task1 {
    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Kyiv", "Ukraine", 2884000),
                new City("Dnipro", "Ukraine", 966400),
                new City("Odessa", "Ukraine", 993120),
                new City("Rome", "Italy", 2873000),
                new City("Milan", "Italy", 1352310),
                new City("Milan", "Italy", 1352000),
                new City("Turin", "Italy", 886837)
        );
        System.out.println(isBiggerPopulation(cities, 100000));
        System.out.println(isBiggerPopulation(cities, 1000000));
        String country1 = "Ukraine";
        String country2 = "Italy";
        System.out.println("Biggest: " + biggestCity(cities, country1));
        System.out.println("Biggest: " + biggestCity(cities, country2));
        mapCities(cities)
                .forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public static boolean isBiggerPopulation(List<City> cities, int populationToCheck) {
        return cities.stream()
                .allMatch(city -> city.population() > populationToCheck);
    }

    public static City biggestCity(List<City> cities, String countryToFind) {
        return cities.stream()
                .filter(city -> city.country().equalsIgnoreCase(countryToFind))
                .max(Comparator.comparing(City::population))
                .orElseThrow(NoSuchElementException::new);
    }

    public static Map<String, City> mapCities(List<City> cities) {
        return cities.stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (city, city2) -> city));
    }
}


record City(String name, String country, int population) { }