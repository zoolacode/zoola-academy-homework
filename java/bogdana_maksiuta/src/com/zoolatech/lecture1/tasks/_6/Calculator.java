package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**
 * 6. Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the operation:
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values.
 * Create two versions of the program: one should use the if-else statement, second - the switch statement.
 *         a. Input: 7
 *            5
 *            +
 * Output: 12
 *         b. Input: 7
 *           5
 *           %
 * 		Output: 2
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter second number:");
        int secondNumber = scanner.nextInt();
        System.out.println("Add arithmetic operation:");
        char symbol = scanner.next().charAt(0);

        ifElseCalculator(firstNumber, secondNumber, symbol);
        switchCaseCalculator(firstNumber, secondNumber, symbol);
    }

    public static void ifElseCalculator(int firstNumber, int secondNumber, char symbol) {
        if (symbol == '+') {
            int result = firstNumber + secondNumber;
            System.out.println(firstNumber + " + " + secondNumber + " = " + result);
        }
        if (symbol == '-') {
            int result = firstNumber - secondNumber;
            System.out.println(firstNumber + " - " + secondNumber + " = " + result);
        }
        if (symbol == '*') {
            int result = firstNumber * secondNumber;
            System.out.println(firstNumber + " * " + secondNumber + " = " + result);
        }
        if (symbol == '/') {
            if (secondNumber == 0) {
                System.out.println("Cannot divide by 0");
            } else {
                int result = firstNumber / secondNumber;
                System.out.println(firstNumber + " / " + secondNumber + " = " + result);
            }
        }
        if (symbol == '%') {
            if (secondNumber == 0) {
                System.out.println("Cannot divide by 0");
            } else {
                int result = firstNumber % secondNumber;
                System.out.println(firstNumber + " % " + secondNumber + " = " + result);
            }
        }
    }

    public static void switchCaseCalculator(int firstNumber, int secondNumber, char symbol) {
        switch (symbol) {
            case '+' -> {
                int result = firstNumber + secondNumber;
                System.out.println(firstNumber + " + " + secondNumber + " = " + result);
            }
            case '-' -> {
                int result = firstNumber - secondNumber;
                System.out.println(firstNumber + " - " + secondNumber + " = " + result);
            }
            case '*' -> {
                int result = firstNumber * secondNumber;
                System.out.println(firstNumber + " * " + secondNumber + " = " + result);
            }
            case '/' -> {
                if (secondNumber == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    int result = firstNumber / secondNumber;
                    System.out.println(firstNumber + " / " + secondNumber + " = " + result);
                }
            }
            case '%' -> {
                if (secondNumber == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    int result = firstNumber % secondNumber;
                    System.out.println(firstNumber + " % " + secondNumber + " = " + result);
                }
            }
        }
    }
}

