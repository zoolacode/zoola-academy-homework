package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class City has the following properties: string name, string country, int population.
 * Create methods (all of them need to use Stream API) that accepts a list of cities and a value of a population,
 * and returns true if all cities in the list have the population bigger than a passed value
 * that accepts a list of cities and a country name and returns a city with the biggest population for that country
 * that accepts a list of cities and returns a map, where the key is the city name and a value -
 * is a corresponding city object (note: the list might contain duplicates)
 */
public class TaskOne {
    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Kyiv", "Ukraine", 5_505_000),
                new City("Kyiv", "Ukraine", 5_505_000),
                new City("San Francisco", "USA", 354_000),
                new City("New York", "USA", 14000),
                new City("New York", "USA", 14000),
                new City("Madrid", "Spain", 34000),
                new City("Barcelona", "Spain", 3_450_000),
                new City("Las Vegas", "USA", 74000));

        System.out.println(checkPopulation(cities, 1000));
        System.out.println(checkPopulation(cities, 100_000));
        System.out.println("------------------------------------------------");
        System.out.println(findCityBiggestPopulation(cities, "Spain"));
        System.out.println("------------------------------------------------");

        convertToMap(cities)
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static boolean checkPopulation(List<City> cities, int population) {
        return cities
                .stream()
                .allMatch(c -> c.population() > population);
    }

    public static City findCityBiggestPopulation(List<City> cities, String country) {
        return cities
                .stream()
                .filter(city -> city.country().equals(country))
                .max(Comparator.comparingInt(City::population))
                .get();
    }

    public static Map<String, City> convertToMap(List<City> cities) {
        return cities
                .stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (city, city2) -> city));
    }
}

