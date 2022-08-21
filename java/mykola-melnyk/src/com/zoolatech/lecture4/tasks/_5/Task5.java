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
        switch (operator) {
            case '+' -> System.out.println("Result is: " + firstnum.add(secondnum));
            case '-' -> System.out.println("Result is: " + firstnum.subtract(secondnum));
            case '*' -> System.out.println("Result is: " + firstnum.multiply(secondnum));
            case '/' -> System.out.println("Result is: " + firstnum.divide(secondnum));
            case '%' -> System.out.println("Result is: " + firstnum.remainder(secondnum));
        }
    }
}
