package com.zoolatech.lecture6.tasks._1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class City has the following properties: string name, string country,
 * int population. Create methods (all of them need to use Stream API)
 * a. that accepts a list of cities and a value of a population, and
 * returns true if all cities in the list have the population bigger than
 * a passed value
 * b. that accepts a list of cities and a country name and returns a city
 * with the biggest population for that country
 * c. that accepts a list of cities and returns a map, where the key is the
 * city name and a value - is a corresponding city object
 * (note: the list might contain duplicates)
 */

public class Task1 {

    public static void main(String[] args) {
        List<City> list = new ArrayList<>();
        list.add(new City("Kyiv", "Ukraine", 2_884_000));
        list.add(new City("Lviv", "Ukraine", 721_301));
        list.add(new City("Kharkiv", "Ukraine", 1_419_000));
        list.add(new City("Cairo", "Egypt", 9_540_000));
        list.add(new City("Cairo", "Egypt", 9_540_000));
        list.add(new City("Alexandria", "Egypt", 5_200_000));
        list.add(new City("Kotor", "Montenegro", 13_510));
        list.add(new City("Herceg Novi", "Montenegro", 33_000));
        list.add(new City("Podgorica", "Montenegro", 156_000));

        System.out.println(isPopulationBiggerThanValue(list, 10_000));
        System.out.println(isPopulationBiggerThanValue(list, 20_000_000));
        System.out.println();
        System.out.println(getCityWithBiggestPopulation(list, "Ukraine"));
        System.out.println(getCityWithBiggestPopulation(list, "Montenegro"));
        System.out.println(getCityWithBiggestPopulation(list, "Egypt"));
        System.out.println();
        getCitiesMap(list).forEach((k, v) -> System.out.println(k + " - " + v));
    }

    public static boolean isPopulationBiggerThanValue(List<City> list, int population) {
        return list.stream().allMatch(c -> c.population() > population);
    }

    public static City getCityWithBiggestPopulation(List<City> list, String country) {
        return list.stream()
                .filter(c -> c.country().equalsIgnoreCase(country))
                .max(Comparator.comparingInt(City::population))
                .orElseThrow(() -> new IllegalArgumentException("There is no such country in the list!"));
    }

    public static Map<String, City> getCitiesMap(List<City> list) {
        return list.stream().collect(Collectors.toMap(City::name, Function.identity(), (c1, c2) -> c1));
    }

    record City(String name, String country, int population) {}
}
