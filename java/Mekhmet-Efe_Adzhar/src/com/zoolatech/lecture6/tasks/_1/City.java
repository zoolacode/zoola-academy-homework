package com.zoolatech.lecture6.tasks._1;
import java.util.Objects;

record City(String name, String country, int population) {

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return getPopulation() == city.getPopulation()
                && Objects.equals(getName(), city.getName())
                && Objects.equals(getCountry(), city.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry(), getPopulation());
    }
}