package com.zoolatech.lecture4.tasks._4;

import java.util.Locale;

public enum Weight {
    GRAM("g", 1, 0.001, 0.035, 453.6, 1e+6),
    KILOGRAM("kg", 1000, 1, 0.028, 0.453, 1000),
    OUNCE("oz", 28.35, 35.274, 1, 16, 35274),
    POUND("lb", 453.6, 2.205, 0.062, 1, 2205),
    TON("t", 1000000, 1000, 2.835e-5, 0.0004, 1);

    private String string;
    private double indexG;
    private double indexKg;
    private double indexOz;
    private double indexLb;
    private double indexT;

    Weight(String string, double indexG, double indexKg, double indexOz, double indexLb, double indexT) {
        this.string = string;
        this.indexG = indexG;
        this.indexKg = indexKg;
        this.indexOz = indexOz;
        this.indexLb = indexLb;
        this.indexT = indexT;
    }

    public void calculate(String weightName, double value) {
        double result = switch (weightName.toUpperCase(Locale.ROOT)) {
            case "GRAM" -> value * this.indexG;
            case "KILOGRAM" -> value * this.indexKg;
            case "OUNCE" -> value * this.indexOz;
            case "POUND" -> value * this.indexLb;
            case "TON" -> value * this.indexT;
            default -> throw new IllegalStateException("Unexpected value: " + weightName.toUpperCase(Locale.ROOT));
        };
        System.out.println(this + " " + value + " in " + weightName + ": " + result);
    }

    public String getString() {
        return string;
    }
}
