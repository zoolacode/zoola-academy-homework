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
        System.out.println(number6.calculatorIfElseVersion());
        number6.calculatorSwitchCaseVersion();

    }

    private String calculatorIfElseVersion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type First Number:");
        int number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        int number2 = scanner.nextInt();
        System.out.println("Select operation:");

        char operation = scanner.next().charAt(0);
        char addition = '+';
        char subtraction = '-';
        char multiplication = '*';
        char division = '/';
        char modulus = '%';

        if (operation == addition) {
            return "Result:" + (number1 + number2);
        } else if (operation == subtraction) {
            return"Result:" + (number1 - number2);
        } else if (operation == multiplication) {
            return"Result:" + (number1 * number2);
        } else if (operation == division) {
            return "Result:" + (number1 / number2);
        } else if (operation == modulus) {
            return "Result:" + (number1 % number2);
        } else {
            throw new IllegalArgumentException("Unknown operator");
        }
    }

    private void calculatorSwitchCaseVersion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type First Number:");
        int number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        int number2 = scanner.nextInt();
        System.out.println("Select operation:");
        char operation = scanner.next().charAt(0);

        int calculate = switch (operation) {
            case '+' -> number1 + number2;
            case '-' -> number1 - number2;
            case '*' -> number1 * number2;
            case '/' -> number1 / number2;
            case '%' -> number1 % number2;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        System.out.println("Result: " + calculate);
    }
}