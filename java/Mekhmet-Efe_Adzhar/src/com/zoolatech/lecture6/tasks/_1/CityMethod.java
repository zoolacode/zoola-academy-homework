package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface CityMethods {
    default boolean populationBiggerThanAPassedValue(List<City> cityList, int passedValue) {
        return cityList.stream()
                .allMatch(city -> city.getPopulation() > passedValue);
    }

    default String mostPopulatedCityForASpecificCountry(List<City> cityList, String country) {
        return cityList.stream()
                .filter(city -> country.equalsIgnoreCase(city.getCountry()))
                .max(Comparator.comparingInt(City::getPopulation))
                .map(City::getName).orElse("Error");
    }

    default Map<String, City> citiesMap(List<City> cityList) {
        return cityList.stream().collect(Collectors.toMap(City::getName, city -> city));
    }
}