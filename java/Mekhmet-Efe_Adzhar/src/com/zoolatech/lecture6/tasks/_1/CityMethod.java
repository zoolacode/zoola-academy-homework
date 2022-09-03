package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class CityMethods {

    public boolean populationBiggerThanAPassedValue(List<City> cityList, int passedValue) {
        return cityList.stream()
                .allMatch(city -> city.population() > passedValue);
    }

    public String mostPopulatedCityForASpecificCountry(List<City> cityList, String country) throws Exception {
        return cityList.stream()
                .filter(city -> country.equalsIgnoreCase(city.country()))
                .max(Comparator.comparingInt(City::population))
                .map(City::name).orElseThrow(Exception::new);
    }

    public Map<String, List<City>> citiesMap(List<City> cityList) {
        return cityList.stream()
                .collect(Collectors.groupingBy(City::name));
    }
}