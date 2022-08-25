package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character) and outputs the result
 * of the selected operation. Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should
 * work with decimal numbers of any length and precision.
 */
public class TaskFive {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String answer = "";
        do {
            System.out.println("Input first value:");
            BigDecimal value1 = new BigDecimal(scanner.next());

            System.out.println("Input second value:");
            BigDecimal value2 = new BigDecimal(scanner.next());

            System.out.println("Input operator ('+','-','*','/'):");
            char operator = scanner.next().charAt(0);

            System.out.println(calculate(value1, value2, operator));

            System.out.println("Do you want to continue(Y/N)");
            answer = scanner.next();
        } while (answer.equalsIgnoreCase("Y"));
    }

    private static BigDecimal calculate(BigDecimal v1, BigDecimal v2, char operation) {
        if (operation == '/' || operation == '%') {
            try {
                checkValueOfOperation(v2);
            } catch (ArithmeticException e) {
                e.printStackTrace();
                return v1;
            }
        }

        return switch (operation) {
            case '+' -> v1.add(v2);
            case '-' -> v1.subtract(v2);
            case '*' -> v1.multiply(v2);
            case '/' -> v1.divide(v2);
            case '%' -> v1.remainder(v2);
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    private static void checkValueOfOperation(BigDecimal value) {
        if (value.equals(new BigDecimal("0"))) {
            throw new ArithmeticException("Division by zero is forbidden");
        }
    }
}

