package com.zoolatech.lecture4.tasks._4;

/**
 * Create an enum class that represents the following weight units: gram,
 * kilogram, ounce, pound, ton. The class should provide methods to get
 * an abbreviation for a unit (g, kg, oz, lb, t), convert a value from a
 * source unit to a current one (method should accept a value and a source
 * unit), and method that allows to get the enum value by a string representation,
 * that can be passed in any case (e.g., for strings “gram”, “Gram”, “GRAM”
 * the method should return an enum value for the gram unit).
 */

public class Task4 {
    public static void main(String[] args) {
        System.out.println(WeightUnit.GRAM.getAbbreviation());
        WeightUnit myUnit = WeightUnit.getValueByName("kilogram");
        System.out.println(WeightUnit.KILOGRAM.getAbbreviation());

        WeightUnit.KILOGRAM.convert(2, "ton");
        WeightUnit.GRAM.convert(1, "ounce");
        WeightUnit.GRAM.convert(5, "kilogram");
    }
}
