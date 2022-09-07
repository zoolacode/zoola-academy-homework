package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation
 * (as a character) and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The
 * program should work with decimal numbers of any length and precision.
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal number1;
        if(scanner.hasNextBigDecimal()){
            number1 = scanner.nextBigDecimal();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        BigDecimal number2;
        if(scanner.hasNextBigDecimal()){
            number2 = scanner.nextBigDecimal();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        char operator;
        if(scanner.hasNext()){
            operator = scanner.next().charAt(0);
        } else {
            throw new IllegalArgumentException("Enter character value");
        }

        numbersEvaluationCaseMethod(number1, number2, operator);
    }

    public static void numbersEvaluationCaseMethod(BigDecimal number1, BigDecimal number2, char c) {
        printResult(switch (c) {
            case '+' -> number1.add(number2);
            case '-' -> number1.subtract(number2);
            case '*' -> number1.multiply(number2);
            case '/' -> number1.divide(number2, 5, RoundingMode.CEILING);
            case '%' -> number1.remainder(number2);
            default -> throw new IllegalArgumentException("Enter symbol of an operation");
        });
    }

    public static void printResult(BigDecimal result){
        System.out.println(result);
    }
}
