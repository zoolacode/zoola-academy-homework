package com.zoolatech.lecture4.tasks._4;

import java.util.Scanner;
import java.util.Objects;

/**
 * Create an enum class that represents the following weight units: gram, kilogram, ounce, pound, ton.
 * The class should provide methods to get an abbreviation for a unit (g, kg, oz, lb, t), convert a value
 * from a source unit to a current one (method should accept a value and a source unit), and method that
 * allows to get the enum value by a string representation, that can be passed in any case
 * (e.g., for strings “gram”, “Gram”, “GRAM” the method should return an enum value for the gram unit).
 */

public class Task4 {
    enum Weight {
        Gram("g", 1), Kilogram("kg", 1000), Ounce("oz", 28.35f), Pound("lb", 453.592f), Ton("t", 1000000);
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

        public void convertation(float value, Weight weight) {
            float result = value * coefficient / weight.coefficient;
            System.out.println(value + abbreviation + " = " + result + weight.abbreviation);
        }
    }

    public static void main(String[] args) {
        for (Weight weight : Weight.values()) {
            System.out.println("Abbreviation for " + weight + " is " + weight.getAbbreviation());
        }

        Weight.Kilogram.convertation(12, Weight.Ounce);
        Weight.Pound.convertation(1500.5f, Weight.Ton);
        Weight.Ounce.convertation(100, Weight.Pound);


        System.out.print("Enter the type to know its coefficient: ");
        Scanner sc = new Scanner(System.in);
        String weightType = sc.next();
        getCoefficient(weightType);
    }

    public static void getCoefficient(String weightType) {
        weightType = weightType.toLowerCase();
        weightType = weightType.substring(0, 1).toUpperCase() + weightType.substring(1);
        for (Weight weight : Weight.values()) {
            if (Objects.equals(weightType, weight.toString())) {
                System.out.println("Coefficient of " + weightType + " is " + weight.getCoefficient());
                return;
            }
        }
        System.out.println("No similar types!");
    }
}
