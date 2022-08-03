package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the operation:
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work with decimal numbers of any length and precision.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:" );
        BigDecimal value1 = new BigDecimal(scanner.next());
        System.out.println("Enter a number:" );
        BigDecimal value2 = new BigDecimal(scanner.next());
        System.out.println("Enter a symbol:" );
        char symbol = scanner.next().charAt(0);

        CalculatorBigNumbers calculatorBigNumbers = new CalculatorBigNumbers();
        calculatorBigNumbers.calculator(value1, value2, symbol);
    }
}
