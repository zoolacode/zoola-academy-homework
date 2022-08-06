package com.zoolatech.lecture4.tasks._5;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character) and outputs the result of
 * the selected operation. Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work
 * with decimal numbers of any length and precision.
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first number:");
        BigDecimal firstnum = in.nextBigDecimal();
        System.out.println("Enter operator (+, -, *, /, %):");
        char operator = in.next().charAt(0);
        System.out.println("Enter second number:");
        BigDecimal secondnum = in.nextBigDecimal();
        BigDecimal result = null;
        switch (operator) {
            case '+' -> {
                result = firstnum.add(secondnum);
            }
            case '-' -> {
                result = firstnum.subtract(secondnum);
            }
            case '*' -> {
                result = firstnum.multiply(secondnum);
            }
            case '/' -> {
                result = firstnum.divide(secondnum);
            }
            case '%' -> {
                result = firstnum.remainder(secondnum);
            }
        }
        System.out.println("Result is: " + result);
    }
}
