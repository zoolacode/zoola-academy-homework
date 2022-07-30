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
        System.out.println(calculator(new BigDecimal("150"), new BigDecimal("100000000000000000000000000"), 'd'));
        System.out.println(calculator(new BigDecimal("150"), new BigDecimal("0"), '%'));
        System.out.println(calculator(new BigDecimal("25.3"), new BigDecimal("8"), '%'));
    }

    static BigDecimal calculator(BigDecimal firstNum, BigDecimal secondNum, char operation) {
        try {
            return switch (operation) {
                case '+' -> firstNum.add(secondNum);
                case '-' -> firstNum.subtract(secondNum);
                case '*' -> firstNum.multiply(secondNum);
                case '%' -> firstNum.remainder(secondNum);
                case '/' -> firstNum.divide(secondNum);
                default -> throw new IllegalStateException("Unexpected operation: " + operation);
            };
        } catch (IllegalStateException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is forbidden");
        }
        return null;
    }
}
