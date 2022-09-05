package com.zoolatech.lecture4.tasks._4;

/**
 * Create an enum class that represents the following weight units: gram,
 * kilogram, ounce, pound, ton. The class should provide methods to get an
 * abbreviation for a unit (g, kg, oz, lb, t), convert a value from a source
 * unit to a current one (method should accept a value and a source unit),
 * and method that allows to get the enum value by a string representation,
 * that can be passed in any case (e.g., for strings “gram”, “Gram”, “GRAM”
 * the method should return an enum value for the gram unit).
 */

public class Task4 {
    public static void main(String[] args) {
        System.out.println(Weight.GRAM.getAbbreviation());
        System.out.println(Weight.KILOGRAM.getAbbreviation());
        System.out.println();

        System.out.println("Convert Kilogram to Ton:");
        System.out.println(Weight.TON.convert(66, Weight.KILOGRAM));
        System.out.println("Convert Ounce to Pound:");
        System.out.println(Weight.POUND.convert(14, Weight.OUNCE));
        System.out.println("Convert Gram to Ounce:");
        System.out.println(Weight.OUNCE.convert(100, Weight.GRAM));
        System.out.println();

        System.out.println(Weight.getValue("gram"));
        System.out.println(Weight.getValue("Kilogram"));
        Weight w = Weight.getValue("OuNcE");
        System.out.println(w);
    }
}
