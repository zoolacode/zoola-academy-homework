package com.zoolatech.lecture4.tasks._4;

public class WeightValue {
    Weight type;
    double value;

    public WeightValue(Weight type, double value) {
        this.type = type;
        this.value = value;
    }

    public void calculateTo(String name){
        type.calculate(name, value);
    }

    public Weight getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
