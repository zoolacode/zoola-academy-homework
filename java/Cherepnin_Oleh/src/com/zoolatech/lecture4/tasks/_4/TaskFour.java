package com.zoolatech.lecture4.tasks._4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create an enum class that represents the following weight units: gram, kilogram, ounce, pound, ton.
 * The class should provide methods to get an abbreviation for a unit (g, kg, oz, lb, t), convert a value from
 * a source unit to a current one (method should accept a value and a source unit), and method that allows to get
 * the enum value by a string representation, that can be passed in any case (e.g., for strings “gram”, “Gram”, “GRAM”
 * the method should return an enum value for the gram unit).
 */
public class TaskFour {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        WeightValue weightValue = new WeightValue(getWeight(), initValue());
        convertValue(weightValue);
    }

    private static Weight getWeight() {
        System.out.println("Input weight type (g, kg, oz, lb, t):");
        String str = scanner.next();
        Weight weight = Arrays.stream(Weight.values())
                .filter(w -> w.getString().equalsIgnoreCase(str))
                .findFirst()
                .get();
        return weight;
    }

    private static double initValue() {
        System.out.println("Input value:");
        double value = scanner.nextDouble();
        return value;
    }

    private static void convertValue(WeightValue weightValue) {
        System.out.println("Input type to convert:");
        String convertType = scanner.next();
        weightValue.calculateTo(convertType);
    }
}

