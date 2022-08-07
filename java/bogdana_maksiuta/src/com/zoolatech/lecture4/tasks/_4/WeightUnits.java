package com.zoolatech.lecture4.tasks._4;

/**
 * Create an enum class that represents the following weight units: gram, kilogram, ounce, pound, ton.
 * The class should provide methods to get an abbreviation for a unit (g, kg, oz, lb, t),
 * convert a value from a source unit to a current one (method should accept a value and a source unit),
 * and method that allows to get the enum value by a string representation, that can be passed in any case
 * (e.g., for strings “gram”, “Gram”, “GRAM” the method should return an enum value for the gram unit).
 */
public enum WeightUnits {
    GRAM            ("gram", 1, 1_000, 28.3495, 453.5924, 1_000_000),
    KILOGRAM        ("kilogram", 0.001, 1, 0.0283, 0.4536, 1_000),
    OUNCE           ("ounce", 0.0353, 35.274, 1, 16, 35_273.962),
    POUND           ("pound", 0.0022, 2.2046, 0.0625, 1, 2_204.622),
    TON             ("ton", 0.000_001, 0.001, 2.835, 0.000_45, 1);

    private final String unitName;
    private final double gram;
    private final double kilogram;
    private final double ounce;
    private final double pound;
    private final double ton;

    WeightUnits(String unitName, double gram, double kilogram, double ounce, double pound, double ton) {
        this.unitName = unitName;
        this.gram = gram;
        this.kilogram = kilogram;
        this.ounce = ounce;
        this.pound = pound;
        this.ton = ton;
    }

    public static WeightUnits getUnitIgnoreCase(String name) {
        return valueOf(name.toUpperCase());
    }

    public void unitsConverter(String sourceUnit, double value) {
        double returnValue = 1;
        switch (sourceUnit.toLowerCase()) {
            case "gram" -> returnValue = value * gram;
            case "kilogram" -> returnValue = value * kilogram;
            case "ounce" -> returnValue = value * ounce;
            case "pound" -> returnValue = value * pound;
            case "ton" -> returnValue = value * ton;
        }
        System.out.println(value + " " + sourceUnit + " = " + returnValue + " " + unitName);
    }

    private String abbreviation;

    public String getAbbreviation(WeightUnits weightUnits) {
        switch (weightUnits) {
            case GRAM -> abbreviation = "g";
            case KILOGRAM -> abbreviation = "kg";
            case OUNCE -> abbreviation = "oz";
            case POUND -> abbreviation = "lb";
            case TON -> abbreviation = "t";
        }
        return abbreviation;
    }

    @Override
    public String toString() {
        return unitName;
    }
}

class Main {
    public static void main(String[] args) {
        WeightUnits unit = WeightUnits.getUnitIgnoreCase("gRaM");
        System.out.println(unit);
        System.out.println(unit.getAbbreviation(unit));
        unit.unitsConverter("kiLogram", 20);

        WeightUnits unit1 = WeightUnits.KILOGRAM;
        System.out.println(unit1.getAbbreviation(unit1));
        System.out.println(unit1);
        unit1.unitsConverter("gram", 100);

        WeightUnits unit2 = WeightUnits.getUnitIgnoreCase("Pound");
        System.out.println(unit2);
        unit2.unitsConverter("Ounce", 1000);
    }
}

