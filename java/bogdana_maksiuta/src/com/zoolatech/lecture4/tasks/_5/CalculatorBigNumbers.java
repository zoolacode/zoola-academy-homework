package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorBigNumbers {
    void calculator (BigDecimal value1, BigDecimal value2, char symbol) {
        BigDecimal resultOfCalculation = switch (symbol) {
            case '+' -> value1.add(value2);
            case '-' -> value1.subtract(value2);
            case '*' -> value1.multiply(value2);
            case '/' -> value1.divide(value2, 8, RoundingMode.HALF_DOWN);
            default -> throw new IllegalArgumentException();
        };
        System.out.println("Result of " + value1 + " " + symbol + " " + value2 + " = " + resultOfCalculation);
    }
}
