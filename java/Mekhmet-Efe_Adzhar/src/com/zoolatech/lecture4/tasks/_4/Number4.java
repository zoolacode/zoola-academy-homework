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
        Weight weight;
        System.out.println(Weight.abbreviation(Weight.KILOGRAM));
        System.out.println(Weight.enumValueByAString("lb"));
        System.out.println(Weight.convertValue(1, Weight.GRAM, Weight.KILOGRAM));
    }
}

enum Weight {
    GRAM,
    KILOGRAM,
    OUNCE,
    POUND,
    TON;

    static String abbreviation(Weight weight) {
        return switch (weight) {
            case GRAM -> "gr";
            case KILOGRAM -> "kg";
            case OUNCE -> "oz";
            case POUND -> "lb";
            case TON -> "t";
        };
    }

    static String convertValue(float mass, Weight sourceUnit, Weight convertTo) {
        //MARK: GRAM
        if (sourceUnit == GRAM && convertTo == KILOGRAM) {
            System.out.println("Converting Gram to Kilogram...");
            return ((mass / 1000) + " " + KILOGRAM);
        } else if (sourceUnit == GRAM && convertTo == OUNCE) {
            System.out.println("Converting Gram to Kilogram...");
            return ((mass / 28.35) + " " + OUNCE);
        } else if (sourceUnit == GRAM && convertTo == POUND) {
            System.out.println("Converting Gram to Kilogram...");
            return ((mass / 453.6) + " " + POUND);
        } else if (sourceUnit == GRAM && convertTo == TON) {
            System.out.println("Converting Gram to Kilogram...");
            return ((mass / 1000000) + " " + TON);

            //MARK: KILOGRAM
        } else if (sourceUnit == KILOGRAM && convertTo == GRAM) {
            System.out.println("Converting Kilogram to Gram...");
            return ((mass * 1000) + " " + GRAM);
        } else if (sourceUnit == KILOGRAM && convertTo == OUNCE) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 35.274) + " " + OUNCE);
        } else if (sourceUnit == KILOGRAM && convertTo == POUND) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 2.205) + " " + POUND);
        } else if (sourceUnit == KILOGRAM && convertTo == TON) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 1000) + " " + POUND);

            //MARK: OUNCE
        } else if (sourceUnit == OUNCE && convertTo == GRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 28.35) + " " + GRAM);
        } else if (sourceUnit == OUNCE && convertTo == KILOGRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 35.274) + " " + KILOGRAM);
        } else if (sourceUnit == OUNCE && convertTo == POUND) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 16) + " " + POUND);
        } else if (sourceUnit == OUNCE && convertTo == TON) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 283495231250000F) + " " + TON);

            //MARK: POUND
        } else if (sourceUnit == POUND && convertTo == GRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 453.6) + " " + GRAM);
        } else if (sourceUnit == POUND && convertTo == KILOGRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 2.205) + " " + KILOGRAM);
        } else if (sourceUnit == POUND && convertTo == OUNCE) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 16) + " " + OUNCE);
        } else if (sourceUnit == POUND && convertTo == TON) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass / 2205) + " " + TON);

            //MARK: TON
        } else if (sourceUnit == TON && convertTo == GRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 1000000) + " " + GRAM);
        } else if (sourceUnit == TON && convertTo == KILOGRAM) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 1000) + " " + KILOGRAM);
        } else if (sourceUnit == TON && convertTo == OUNCE) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 35270) + " " + OUNCE);
        } else if (sourceUnit == TON && convertTo == POUND) {
            System.out.println("Converting Kilograms to OUNCE...");
            return ((mass * 2205) + " " + POUND);
        }
        return "ERROR";
    }

    static Weight enumValueByAString(String string) {
        switch (string) {
            case "GRAM", "Gram", "gram", "gr" -> {
                return GRAM;
            }
            case "KILOGRAM", "Kilogram", "kilogram", "kg" -> {
                return KILOGRAM;
            }
            case "OUNCE", "Ounce", "ounce", "oz" -> {
                return OUNCE;
            }
            case "POUND", "Pound", "pound", "lb" -> {
                return POUND;
            }
            case "TON", "Ton", "ton", "t" -> {
                return TON;
            }
        }
        return GRAM;
    }
}