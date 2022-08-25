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
        Weight weight = Weight.GRAM;
        System.out.println(weight.abbreviationOfCurrentWeight());
        System.out.println(Weight.GRAM.convertValue(1000, Weight.KILOGRAM));
        System.out.println(Weight.enumValueByAString("GrAm"));
        System.out.println(weight.convertValue(1, Weight.KILOGRAM));
    }
}

enum Weight {
    GRAM("gr"),
    KILOGRAM("kg"),
    OUNCE("oz"),
    POUND("lb"),
    TON("t");

    private String abbreviation;

    Weight(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String abbreviationOfCurrentWeight() {
        return this.abbreviation;
    }

    public float convertValue(float mass, Weight sourceUnit) {
        if (this == GRAM) {
            if (sourceUnit == GRAM) {
                return mass;
            } else if (sourceUnit == KILOGRAM) {
                return mass / 1000;
            } else if (sourceUnit == OUNCE) {
                return mass / 28.35F;
            } else if (sourceUnit == POUND) {
                return mass / 453.6F;
            } else if (sourceUnit == TON) {
                return mass / 1000000;
            }
        } else if (this == KILOGRAM) {
            if (sourceUnit == GRAM) {
                return mass * 1000;
            } else if (sourceUnit == KILOGRAM) {
                return mass;
            } else if (sourceUnit == OUNCE) {
                return mass * 35.274F;
            } else if (sourceUnit == POUND) {
                return mass * 2.205F;
            } else if (sourceUnit == TON) {
                return mass / 1000;
            }
        } else if (this == OUNCE) {
            if (sourceUnit == GRAM) {
                return mass * 28.35F;
            } else if (sourceUnit == KILOGRAM) {
                return mass / 35.274F;
            } else if (sourceUnit == OUNCE) {
                return mass;
            } else if (sourceUnit == POUND) {
                return mass / 16;
            } else if (sourceUnit == TON) {
                return mass / 283495231250000F;
            }
        } else if (this == POUND) {
            if (sourceUnit == GRAM) {
                return mass * 453.6F;
            } else if (sourceUnit == KILOGRAM) {
                return mass / 2.205F;
            } else if (sourceUnit == OUNCE) {
                return mass * 16;
            } else if (sourceUnit == POUND) {
                return mass;
            } else if (sourceUnit == TON) {
                return mass / 2205;
            }
        } else if (this == TON) {
            if (sourceUnit == GRAM) {
                return mass * 1000000;
            } else if (sourceUnit == KILOGRAM) {
                return mass * 1000;
            } else if (sourceUnit == OUNCE) {
                return mass * 35270;
            } else if (sourceUnit == POUND) {
                return mass * 2205;
            } else if (sourceUnit == TON) {
                return mass;
            }
        }
        return mass;
    }

    public static Weight enumValueByAString(String string) {
        switch (string.toUpperCase()) {
            case "GRAM" -> {
                return GRAM;
            }
            case "KILOGRAM" -> {
                return KILOGRAM;
            }
            case "OUNCE" -> {
                return OUNCE;
            }
            case "POUND" -> {
                return POUND;
            }
            case "TON" -> {
                return TON;
            }
        }
        return null;
    }
}