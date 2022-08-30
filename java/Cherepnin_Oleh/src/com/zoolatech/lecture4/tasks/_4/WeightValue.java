package com.zoolatech.lecture4.tasks._4;

public class WeightValue {
    Weight weight;
    double value;

    public WeightValue(Weight type, double value) {
        this.weight = type;
        this.value = value;
    }

    public void calculateTo(String weightName) {
        System.out.println(weight + " " + value + " in " + weightName + ": " + weight.calculate(weightName, value));
    }

    public Weight getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }
}
