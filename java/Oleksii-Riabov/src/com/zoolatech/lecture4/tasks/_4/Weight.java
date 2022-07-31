package com.zoolatech.lecture4.tasks._4;

public enum Weight {
    GRAM ("g"){
        @Override
        public double convert(double d, Weight weight) {
            switch (weight) {
                case GRAM -> {return d;}
                case KILOGRAM -> {return d * 1_000;}
                case OUNCE -> {return d * 28.35;}
                case POUND -> {return d * 453.59;}
                case TON -> {return d * 1_000_000;}
                default -> throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        }
    },
    KILOGRAM ("kg") {
        @Override
        public double convert(double d, Weight weight) {
            switch (weight) {
                case GRAM -> {return d * 0.001;}
                case KILOGRAM -> {return d;}
                case OUNCE -> {return d * 0.02834952;}
                case POUND -> {return d * 0.4536;}
                case TON -> {return d * 1_000;}
                default -> throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        }
    },
    OUNCE ("oz") {
        @Override
        public double convert(double d, Weight weight) {
            switch (weight) {
                case GRAM -> {return d * 0.03527396195;}
                case KILOGRAM -> {return d * 35.27396195;}
                case OUNCE -> {return d;}
                case POUND -> {return d * 16;}
                case TON -> {return d * 35_274;}
                default -> throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        }
    },
    POUND ("lb") {
        @Override
        public double convert(double d, Weight weight) {
            switch (weight) {
                case GRAM -> {return d * 0.0022046226218;}
                case KILOGRAM -> {return d * 2.205;}
                case OUNCE -> {return d * 0.0625;}
                case POUND -> {return d;}
                case TON -> {return d * 2204.6226218;}
                default -> throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        }
    },
    TON ("t") {
        @Override
        public double convert(double d, Weight weight) {
            switch (weight) {
                case GRAM -> {return d * 0.000_001;}
                case KILOGRAM -> {return d * 0.001;}
                case OUNCE -> {return d * 0.00003125;}
                case POUND -> {return d * 0.00045359237;}
                case TON -> {return d;}
                default -> throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        }
    };

    private final String value;
    private static final String INCORRECT_VALUE = "Incorrect value";

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
