package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorUpgraded {
    private final BigDecimal number;
    private final BigDecimal number1;
    private final char operation;

    CalculatorUpgraded(BigDecimal number, BigDecimal number1, char operation) {
        this.number = number;
        this.number1 = number1;
        this.operation = operation;}

    void calculate(){
        switch (operation) {
            case '+' -> System.out.println(number.add(number1));
            case '-' -> System.out.println(number.min(number1));
            case '*' -> System.out.println(number.multiply(number1));
            case '/' -> System.out.println(number.divide(number1));
            case '%' -> System.out.println(number.remainder(number1));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers and operation sign pls: ");
        Scanner sc = new Scanner(System.in);
        BigDecimal number = sc.nextBigDecimal();
        BigDecimal number1 = sc.nextBigDecimal();
        char operation = sc.next().charAt(0);
        CalculatorUpgraded calculatorUpgraded = new CalculatorUpgraded(number, number1, operation);
        calculatorUpgraded.calculate();
    }
}