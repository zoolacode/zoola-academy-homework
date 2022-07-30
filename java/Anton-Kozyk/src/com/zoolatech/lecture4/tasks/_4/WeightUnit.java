package com.zoolatech.lecture4.tasks._4;

public enum WeightUnit {
    GRAM("g", 1),
    KILOGRAM("kg", 1000),
    OUNCE("oz", 28.35),
    POUND("lb", 453.6),
    TON("t", 1000000);

    private final String abbreviation;
    private final double inGram;

    static WeightUnit getValueByName(String name) {
        try {
            String unitName = name.toUpperCase();
            return valueOf(unitName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        }
    }

    WeightUnit(String abbreviation, double inGram) {
        this.abbreviation = abbreviation;
        this.inGram = inGram;
    }

    String getAbbreviation() {
        return abbreviation;
    }

    double convert(int value, String sourceUnit) {
        WeightUnit unit = getValueByName(sourceUnit);
        double result = (value * unit.inGram) / this.inGram;
        System.out.println("In " + value + " " + unit.getAbbreviation() +
                " " + result + " " + this.getAbbreviation());
        return result;
    }
}

