package com.zoolatech.lecture4.tasks._4;

public enum WeightUnits {
    GRAM("g"), KILOGRAM("kg"), OUNCE("oz"),
    POUND("lb"), TON("t");
    private final String abbreviation;
    WeightUnits(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double convertFrom(double value, WeightUnits sourceUnit) {
        double result = 0;
        switch (this) {
            case GRAM -> {
                result = switch (sourceUnit) {
                    case GRAM -> value;
                    case KILOGRAM -> value * 1000;
                    case OUNCE -> value * 28.35;
                    case POUND -> value * 453.6;
                    case TON -> value * 1_000_000;
                };
            }
            case KILOGRAM -> {
                result = switch (sourceUnit) {
                    case GRAM -> value / 1000;
                    case KILOGRAM -> value;
                    case OUNCE -> value / 35.274;
                    case POUND -> value / 2.205;
                    case TON -> value * 1000;
                };
            }
            case OUNCE -> {
                result = switch (sourceUnit) {
                case GRAM -> value / 28.35;
                case KILOGRAM -> value * 35.274;
                case OUNCE -> value;
                case POUND -> value * 16;
                case TON -> value * 35270;
                };
            }
            case POUND -> {
                result = switch (sourceUnit) {
                case GRAM -> value / 453.6;
                case KILOGRAM -> value * 2.205;
                case OUNCE -> value / 16;
                case POUND -> value;
                case TON -> value * 2205;
                };
            }
            case TON -> {
                result = switch (sourceUnit) {
                case GRAM -> value / 1_000_000;
                case KILOGRAM -> value / 1000;
                case OUNCE -> value / 35270;
                case POUND -> value / 2205;
                case TON -> value;
                };
            }
        }
        return result;
    }

    public WeightUnits getUnit(String name) {
        WeightUnits unit = null;
        switch (name.toUpperCase()) {
            case "GRAM" -> {
                unit = WeightUnits.GRAM;
            }
            case "KILOGRAM" -> {
                unit = WeightUnits.KILOGRAM;
            }
            case "OUNCE" -> {
                unit = WeightUnits.OUNCE;
            }
            case "POUND" -> {
                unit = WeightUnits.POUND;
            }
            case "TON" -> {
                unit = WeightUnits.TON;
            }
        }
        return unit;
    }
}


