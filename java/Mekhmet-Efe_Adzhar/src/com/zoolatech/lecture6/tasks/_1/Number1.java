package com.zoolatech.lecture6.tasks._1;

import java.util.*;

/*
Class City has the following properties: string name, string country, int population.
Create methods (all of them need to use Stream API):
a. that accepts a list of cities and a value of a population, and returns true if
all cities in the list have the population bigger than a passed value;
b. that accepts a list of cities and a country name and returns a city with the biggest population for that country;
c. that accepts a list of cities and returns a map,
where the key is the city name and a value - is a corresponding city object (note: the list might contain duplicates).
*/

public class Number1 implements CityMethods{
    public static void main(String[] args) {

        City kiev = new City("Kiev", "Ukraine", 5000000);
        City poltava = new City("Poltava", "Ukraine", 300000);
        List<City> cityList = List.of(kiev, poltava);

        Number1 number1 = new Number1();

        System.out.println(number1.populationBiggerThanAPassedValue(cityList, 100));
        System.out.println(number1.mostPopulatedCityForASpecificCountry(cityList, "Ukraine"));
        System.out.println(number1.citiesMap(cityList));

    }
}