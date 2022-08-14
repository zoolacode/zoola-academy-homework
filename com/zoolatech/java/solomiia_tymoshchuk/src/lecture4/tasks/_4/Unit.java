package com.zoolatech.java.solomiia_tymoshchuk.src.lecture4.tasks._4;

import java.util.Arrays;
import java.util.Collection;

public enum Unit {
    GRAM("g", new Aliases("gram", "grams", "Gram", "gramms")),
    KILOGRAM("kg", new Aliases("kilos", "kilo", "Kilograms", "kgs", "kilograms")),
    OUNCE("oz", new Aliases("ounce", "ounces")),
    POUND("lb", new Aliases("Pound", "lbs", "pound")),
    TON("t", new Aliases("ton", "Ton", "tonnes", "tns"));


    private final String abbreviation;
    private final Unit.Aliases aliases;

    Unit(String abbreviation, Aliases aliases) {
        this.abbreviation = abbreviation;
        this.aliases = aliases;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static Unit getByAlias(String alias) {
        for (Unit unit : Unit.values()) {
            if (unit.hasAlias(alias.toLowerCase())) return unit;
        }
        return null;
    }

    public boolean hasAlias(String al) {
        if (aliases == null) return false;
        else return aliases.contains(al);
    }

    static double convertValue(double value, Unit necessaryValue, Unit initialUnit) {
        double convertedValue = convertValueToG(initialUnit, value);
        return convertValueToDesiredUnit(necessaryValue, convertedValue);
    }

    static double convertValueToDesiredUnit(Unit necessaryValue, double value) {
        double result = 0;
        switch (necessaryValue) {
            case KILOGRAM -> result = value / 1000;
            case OUNCE -> result = value / 28.3;
            case POUND -> result = value / 453.6;
            case TON -> result = value / 907185;
            case GRAM -> result = value;
        }
        return result;
    }

    static double convertValueToG(Unit initialUnit, double value) {
        double result = 0;
        switch (initialUnit) {
            case KILOGRAM -> result = value * 1000;
            case OUNCE -> result = value * 28.3;
            case POUND -> result = value * 453.6;
            case TON -> result = value * 907185;
            case GRAM -> result = value;
        }
        return result;

    }

    public static class Aliases {
        String[] aliases;

        public Aliases(String... aliases) {
            this.aliases = aliases;
        }

        public String[] getAliases() {
            return aliases;
        }

        public Collection<String> getAliasesCollection() {
            return Arrays.asList(aliases);
        }

        public boolean contains(String text) {
            return getAliasesCollection().contains(text);
        }
    }

    public static void main(String[] args) {
        System.out.println(Unit.getByAlias("gram"));
        System.out.println(Unit.GRAM.getAbbreviation());
        System.out.println(Unit.convertValue(111, Unit.KILOGRAM, Unit.GRAM));
    }
}