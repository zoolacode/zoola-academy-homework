package com.zoolatech.lecture2.tasks._1;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator(3);
        calc.divide(0);
        System.out.println(calc.getStoredValue());
    }
}
