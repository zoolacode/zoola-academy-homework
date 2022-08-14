package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public record City(String name, String country, int population) {
    public static boolean isPopulationBigger(List<City> cities, int population) {
        return cities.stream()
                .allMatch(city -> city.population() > population);
    }

    public static Optional<City> mostPopulousCity(List<City> cities, String country) {
        return cities.stream()
                .filter(city -> city.country().equals(country))
                .max(Comparator.comparingInt(City::population));
    }

    public static Map<String, City> toMap(List<City> cities) {
        return cities.stream()
                .collect(Collectors.toMap(City::name, Function.identity(), (prev, next) -> next));
    }

    @Override
    public String toString() {
        return "\nname: '" + name() + '\'' +
                "\ncountry: '" + country() + '\'' +
                "\npopulation: " + population();
    }
}
