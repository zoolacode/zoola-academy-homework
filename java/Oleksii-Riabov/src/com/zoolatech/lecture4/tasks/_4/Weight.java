package com.zoolatech.lecture4.tasks._4;

public enum Weight {
    GRAM ("g"){
        @Override
        public double convert(double d, Weight weight) {
            return switch (weight) {
                case GRAM -> d;
                case KILOGRAM -> d * 1_000;
                case OUNCE -> d * 28.35;
                case POUND -> d * 453.59;
                case TON -> d * 1_000_000;
            };
        }
    },
    KILOGRAM ("kg") {
        @Override
        public double convert(double d, Weight weight) {
            return switch (weight) {
                case GRAM -> d * 0.001;
                case KILOGRAM -> d;
                case OUNCE -> d * 0.02834952 ;
                case POUND -> d * 0.4536;
                case TON -> d * 1_000;
            };
        }
    },
    OUNCE ("oz") {
        @Override
        public double convert(double d, Weight weight) {
            return switch (weight) {
                case GRAM -> d * 0.03527396195;
                case KILOGRAM -> d * 35.27396195;
                case OUNCE -> d;
                case POUND -> d * 16;
                case TON -> d * 35_274;
            };
        }
    },
    POUND ("lb") {
        @Override
        public double convert(double d, Weight weight) {
            return switch (weight) {
                case GRAM -> d * 0.0022046226218;
                case KILOGRAM -> d * 2.205;
                case OUNCE -> d * 0.0625;
                case POUND -> d;
                case TON -> d * 2204.6226218;
            };
        }
    },
    TON ("t") {
        @Override
        public double convert(double d, Weight weight) {
            return switch (weight) {
                case GRAM -> d * 0.000_001;
                case KILOGRAM -> d * 0.001;
                case OUNCE -> d * 0.00003125;
                case POUND -> d * 0.00045359237;
                case TON -> d;
            };
        }
    };

    private final String value;

    Weight(String value) {
        this.value = value;
    }

    public static Weight getValue(String string) {
        return valueOf(string.toUpperCase());
    }

    public abstract double convert(double d, Weight weight);

    public String getAbbreviation() {
        return value;
    }
}
