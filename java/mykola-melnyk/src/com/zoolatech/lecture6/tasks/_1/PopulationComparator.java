package com.zoolatech.lecture6.tasks._1;

import java.util.Comparator;

public class PopulationComparator implements Comparator<City> {

    @Override
    public int compare(City o1, City o2) {
        return Integer.compare(o1.population(), o2.population());
    }
}