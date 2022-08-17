package com.zoolatech.lecture4.tasks._4;

/*
Create an enum class that represents the following weight units: gram, kilogram, ounce, pound, ton.
The class should provide methods to get an abbreviation for a unit (g, kg, oz, lb, t),
convert a value from a source unit to a current one (method should accept a value and a source unit),
and method that allows to get the enum value by a string representation, that can be passed in any case
(e.g., for strings “gram”, “Gram”, “GRAM” the method should return an enum value for the gram unit).
*/

public class Number4 {
    public static void main(String[] args) {
        Weight weight = Weight.abbreviation;
        System.out.println(weight.abbreviation(Weight.KILOGRAM));
        System.out.println(weight.enumValueByAString("GrAm"));
        System.out.println(weight.convertValue(1, Weight.KILOGRAM));
    }
}

enum Weight {
    GRAM,
    KILOGRAM,
    OUNCE,
    POUND,
    TON,
    abbreviation();

    public String abbreviation(Weight weight) {
        return switch (weight) {
            case GRAM -> "gr";
            case KILOGRAM -> "kg";
            case OUNCE -> "oz";
            case POUND -> "lb";
            case TON -> "t";
            case abbreviation -> null;
        };
    }

    public float convertValue(float mass, Weight sourceUnit) {
        switch (sourceUnit) {
            case GRAM -> {
                System.out.println("Converting Gram to Kilogram...");
                return mass / 1000;
            }
            case KILOGRAM -> {
                System.out.println("Converting Kilogram to Ounce...");
                return mass * 35.274F;
            }
            case OUNCE -> {
                System.out.println("Converting Ounce to Pound...");
                return mass * 2.205F;
            }
            case POUND -> {
                System.out.println("Converting Pounds to Ton...");
                return mass / 2205F;
            }
            case TON -> {
                System.out.println("Converting Ton to Pounds...");
                return mass * 2205F;
            }
        }
        return mass;
    }

    public Weight enumValueByAString(String string) {
        if (string.equalsIgnoreCase("GRAM")) {
            return GRAM;
        } else if (string.equalsIgnoreCase("KILOGRAM")) {
            return KILOGRAM;
        } else if (string.equalsIgnoreCase("OUNCE")) {
            return OUNCE;
        } else if (string.equalsIgnoreCase("POUND")) {
            return POUND;
        } else if (string.equalsIgnoreCase("TON")) {
            return TON;
        }
        return abbreviation;
    }
}