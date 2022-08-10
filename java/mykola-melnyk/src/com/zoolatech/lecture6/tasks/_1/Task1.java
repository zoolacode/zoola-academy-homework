package com.zoolatech.lecture6.tasks._1;

import java.util.ArrayList;

/**
 * Class City has the following properties: string name, string country, int population.
 * Create methods (all of them need to use Stream API):
 * a) that accepts a list of cities and a value of a population,
 * and returns true if all cities in the list have the population bigger than a passed value
 * b) that accepts a list of cities and a country name and returns a city with the biggest
 * population for that country
 * c) that accepts a list of cities and returns a map, where the key is the city name and
 * a value - is a corresponding city object (note: the list might contain duplicates).
 */

public class Task1 {
    public static void main(String[] args) {
        City tokyo = new City("Tokyo", "Japan", 37_340_000);
        City delhi = new City("Delhi", "India", 31_181_000);
        City shanghai = new City("Shanghai", "China", 27_796_000);
        City saoPaulo = new City("Sao Paulo", "Brazil", 22_043_028);
        City mexico = new City("Mexico", "Mexico", 21_919_000);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(tokyo);
        cities.add(delhi);
        cities.add(shanghai);
        cities.add(saoPaulo);
        cities.add(mexico);

    }
}
