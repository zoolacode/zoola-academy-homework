package com.zoolatech.lecture4.tasks._4;

import java.util.Scanner;
import java.util.Objects;
import java.util.SortedMap;

/**
 * Create an enum class that represents the following weight units: gram, kilogram, ounce, pound, ton.
 * The class should provide methods to get an abbreviation for a unit (g, kg, oz, lb, t), convert a value
 * from a source unit to a current one (method should accept a value and a source unit), and method that
 * allows to get the enum value by a string representation, that can be passed in any case
 * (e.g., for strings “gram”, “Gram”, “GRAM” the method should return an enum value for the gram unit).
 */

public class Task4 {
    enum Weight {
        GRAM("g", 1), KILOGRAM("kg", 1000), OUNCE("oz", 28.35f), POUND("lb", 453.592f), TON("t", 1000000);
        private final String abbreviation;
        private final float coefficient;

        Weight(String abbreviation, float coefficient) {
            this.abbreviation = abbreviation;
            this.coefficient = coefficient;
        }

        public float getCoefficient() {
            return coefficient;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public float convertation(float value, Weight weight) {
            return value * coefficient / weight.coefficient;
        }

        public void printEquality(float value, Weight weight) {
            float convertedValue = convertation(value, weight);
            System.out.println(value + abbreviation + " = " + convertedValue + weight.abbreviation);
        }

        public Weight getClearType(String weightType) {
            weightType = weightType.toUpperCase();
            if (weightType.equals(this.toString())) {
                return this;
            }
            return null;
        }
    }

    public static void findWeightType(String weightType) {
        for (Weight weight : Weight.values()) {
            Weight resultType = weight.getClearType(weightType);
            if (resultType != null) {
                System.out.println("Coefficient of " + resultType + " is " + resultType.getCoefficient());
                return;
            }
        }
        System.out.println("No similar types for " + weightType);
    }

    public static void main(String[] args) {
        for (Weight weight : Weight.values()) {
            System.out.println("Abbreviation for " + weight + " is " + weight.getAbbreviation());
        }

        float value1 = 12;
        float value2 = 1500.5f;
        float value3 = 100;

        Weight.KILOGRAM.printEquality(value1, Weight.OUNCE);
        Weight.POUND.printEquality(value2, Weight.TON);
        Weight.OUNCE.printEquality(value3, Weight.POUND);

        System.out.println("Enter the type to know its coefficient: ");
        Scanner sc = new Scanner(System.in);
        String weightType = sc.next();
        findWeightType(weightType);
    }
}

