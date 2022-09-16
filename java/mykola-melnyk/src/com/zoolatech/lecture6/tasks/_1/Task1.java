package com.zoolatech.lecture6.tasks._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static boolean checkPopulationIsBigger(ArrayList<City> cityList, int population) {
        return cityList.stream().allMatch(city -> city.population() > population);
    } //Subtask a)

    private static City biggestHere(ArrayList<City> cityList, String countryName) {
        Optional<City> biggestCity = cityList.stream()
                .filter(city -> city.country().equalsIgnoreCase(countryName))
                .sorted(new PopulationComparator())
                .findFirst();
        return biggestCity.get();
    } // Subtask b) ver 1

    private static City biggestHere2(ArrayList<City> cityList, String countryName) {
        Optional<City> biggest = cityList.stream()
                .filter(city -> city.country().equalsIgnoreCase(countryName))
                .max(new PopulationComparator());
        return biggest.orElseThrow(() ->new IllegalArgumentException("Invalid Country " + countryName));
    } // Subtask b) ver 2

    private static Map<String, City> cityMap(ArrayList<City> cityList) {
        return cityList.stream().distinct().collect(Collectors.toMap(City::name, Function.identity()));
    }  // Subtask c)

    public static void main(String[] args) {
        City tokyo = new City("Tokyo", "Japan", 37_340_000);
        City delhi = new City("Delhi", "India", 31_181_000);
        City shanghai = new City("Shanghai", "China", 27_796_000);
        City beijing = new City("Beijing", "China", 22_366_000);
        City saoPaulo = new City("Sao Paulo", "Brazil", 22_043_028);
        City mexico = new City("Mexico", "Mexico", 21_919_000);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(tokyo);
        cities.add(delhi);
        cities.add(shanghai);
        cities.add(saoPaulo);
        cities.add(mexico);
        cities.add(beijing);
        cities.add(beijing);

        System.out.println(checkPopulationIsBigger(cities, 2_000_000));
        System.out.println(biggestHere(cities, "china"));
        System.out.println(biggestHere2(cities, "china"));
        try {
            System.out.println(biggestHere2(cities, "chna"));
        } catch (Exception e) {
            System.out.println("Failed to determine the largest city");
            e.printStackTrace(System.out);
        }
        System.out.println(cityMap(cities));
    }
}