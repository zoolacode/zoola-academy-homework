package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character) and outputs the result
 * of the selected operation. Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should
 * work with decimal numbers of any length and precision.
 */
public class TaskFive {

    private static Scanner scanner = new Scanner(System.in);
    private static Calculator calculator = (v1, v2, op) -> {
        BigDecimal result = switch (op) {
            case '+' -> v1.add(v2, MathContext.DECIMAL32);
            case '-' -> v1.subtract(v2);
            case '*' -> v1.multiply(v2);
            case '/' -> v1.divide(v2, 3, RoundingMode.HALF_EVEN);
            default -> throw new ArithmeticException("Invalid operator");
        };
        return result.stripTrailingZeros();
    };

    public static void main(String[] args) {
        calculate();
    }

    private static void calculate() {
        do {
            System.out.println("Input first value:");
            BigDecimal value1 = new BigDecimal(scanner.next());
            System.out.println("Input second value:");
            BigDecimal value2 = new BigDecimal(scanner.next());
            System.out.println("Input operator ('+','-','*','/'):");
            char operator = scanner.next().charAt(0);
            System.out.println(calculator.calculate(value1, value2, operator));
            System.out.println("Do you want to continue(Y/N)");
            String answer = scanner.next();
            if (answer.isBlank() || !answer.equalsIgnoreCase("Y")) {
                break;
            }
        } while (true);
    }
}

