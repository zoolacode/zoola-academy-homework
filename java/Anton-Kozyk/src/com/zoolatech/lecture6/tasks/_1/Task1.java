package com.zoolatech.lecture6.tasks._1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class City has the following properties: string name, string country, int population.
 * Create methods (all of them need to use Stream API):
 * <p>
 * • that accepts a list of cities and a value of a population, and returns true if
 * all cities in the list have the population bigger than a passed value
 * <p>
 * • that accepts a list of cities and a country name and returns a city with the
 * biggest population for that country
 * <p>
 * • that accepts a list of cities and returns a map, where the key is the city name
 * and a value - is a corresponding city object (note: the list might contain duplicates)
 */

public class Task1 {
    public static void main(String[] args) {
        City city1 = new City("Kiev", "Ukraine", 3_010_000);
        City city2 = new City("Lviv", "Ukraine", 721_000);
        City city3 = new City("Poltava", "Ukraine", 288_324);
        List<City> cities = List.of(city1, city2, city3);

        System.out.println(City.isPopulationBigger(cities, 100_000_000));
        System.out.println(City.isPopulationBigger(cities, 100_000));

        System.out.println();
        System.out.println(City.mostPopulousCity(cities, "Ukraine"));

        System.out.println();
        List<City> cities1 = new ArrayList<>();
        System.out.println(City.mostPopulousCity(cities1, "Ukraine"));

        System.out.println();

        City.toMap(cities)
                .forEach((k, v) -> System.out.println(k + " " + v + "\n"));

    }
}

