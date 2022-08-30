package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;

/**
 * Write a program that accepts two numbers and a symbol of an operation
 * (as a character) and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The
 * program should work with decimal numbers of any length and precision.
 */

public class Task5 {
    public static void main(String[] args) {
        Calculator.printResult(new BigDecimal("150"), new BigDecimal("100000000000000000000000000"), 'd');
        Calculator.printResult(new BigDecimal("150"), new BigDecimal("0"), '/');
        Calculator.printResult(new BigDecimal("25.3"), new BigDecimal("8"), '%');
    }
}

class Calculator {
    private static BigDecimal calculate(BigDecimal firstNum, BigDecimal secondNum, char operation) {
        return switch (operation) {
            case '+' -> firstNum.add(secondNum);
            case '-' -> firstNum.subtract(secondNum);
            case '*' -> firstNum.multiply(secondNum);
            case '%' -> firstNum.remainder(secondNum);
            case '/' -> firstNum.divide(secondNum);
            default -> throw new IllegalStateException("Unexpected operation: " + operation);
        };
    }

    public static void printResult(BigDecimal firstNum, BigDecimal secondNum, char operation) {
        if (secondNum.equals(new BigDecimal("0")) && (operation == '/' || operation == '%')) {
            System.out.println("Division by zero is forbidden");
            return;
        }

        try {
            System.out.println(firstNum + " " +
                    operation + " " +
                    secondNum + " = " +
                    calculate(firstNum, secondNum, operation));
        } catch (IllegalStateException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
