package com.zoolatech.lecture4.tasks._5;

/*Write a program that accepts two numbers and a symbol of an operation (as a character)
and outputs the result of the selected operation.
Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
The program should work with decimal numbers of any length and precision.
 */

import java.math.BigDecimal;
import java.util.Scanner;

public class Number5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number, operation and second number");
        System.out.println(calculations(scanner.nextBigDecimal(), scanner.next().charAt(0), scanner.nextBigDecimal()));
    }

    public static BigDecimal calculations(BigDecimal numberOne, char operation, BigDecimal numberTwo) {
        switch (operation) {
            case '+' -> {
                return numberOne.add(numberTwo);
            }
            case '-' -> {
                return numberOne.subtract(numberTwo);
            }
            case '*' -> {
                return numberOne.multiply(numberTwo);
            }
            case '/' -> {
                return numberOne.divide(numberTwo);
            }
            case '%' -> {
                return numberOne.remainder(numberTwo);
            }
            default -> {
                return null;
            }
        }
    }
}