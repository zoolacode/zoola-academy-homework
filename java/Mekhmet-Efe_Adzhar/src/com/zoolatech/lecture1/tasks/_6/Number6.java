package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**Write a program that accepts two numbers and a symbol of an operation
 * (as a character) and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
 * The program should work only with integer values.
 * Create two versions of the program:
 * one should use the if-else statement, second - the switch statement.
 */

public class Number6 {
    public static void main(String[] args) {
        Number6 number6 = new Number6();
        System.out.println("Result: " + number6.calculatorIfElseVersion());
        System.out.println("Result: " + number6.calculatorSwitchCaseVersion());

    }

    private int calculatorIfElseVersion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type First Number:");
        int number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        int number2 = scanner.nextInt();
        System.out.println("Select operation:");

        final char operation = scanner.next().charAt(0);
        final char addition = '+';
        final char subtraction = '-';
        final char multiplication = '*';
        final char division = '/';
        final char modulus = '%';

        if (operation == addition) {
            return number1 + number2;
        } else if (operation == subtraction) {
            return number1 - number2;
        } else if (operation == multiplication) {
            return number1 * number2;
        } else if (operation == division) {
            return number1 / number2;
        } else if (operation == modulus) {
            return number1 % number2;
        } else {
            throw new IllegalArgumentException("Unknown operator");
        }
    }

    private int calculatorSwitchCaseVersion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type First Number:");
        int number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        int number2 = scanner.nextInt();
        System.out.println("Select operation:");
        char operation = scanner.next().charAt(0);

        return switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            case '%' -> number1 % number2;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}