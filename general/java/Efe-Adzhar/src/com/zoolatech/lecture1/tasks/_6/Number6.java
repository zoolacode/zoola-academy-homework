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
        number6.calculatorIfElseVersion();
        number6.calculatorSwitchCaseVersion();

    }

    private void calculatorIfElseVersion() {
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;
        char operation;

        char addition = '+';
        char subtraction = '-';
        char multiplication = '*';
        char division = '/';
        char modulus = '%';

        System.out.println("Type First Number:");
        number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        number2 = scanner.nextInt();
        System.out.println("Select operation:");

        operation = scanner.next().charAt(0);

        if (operation == addition) {
            System.out.println("Result:" + (number1 + number2));
        } else if (operation == subtraction) {
            System.out.println("Result:" + (number1 - number2));
        } else if (operation == multiplication) {
            System.out.println("Result:" + (number1 * number2));
        } else if (operation == division) {
            System.out.println("Result:" + (number1 / number2));
        } else if (operation == modulus) {
            System.out.println("Result:" + (number1 % number2));
        } else {
            throw new IllegalArgumentException("Unknown operator: " + operation);
        }
    }

    private void calculatorSwitchCaseVersion() {
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;
        char operation;

        System.out.println("Type First Number:");
        number1 = scanner.nextInt();
        System.out.println("Type Second Number:");
        number2 = scanner.nextInt();
        System.out.println("Select operation:");
        operation = scanner.next().charAt(0);

        int calculate = switch (operation) {
            case '+':
                yield number1 + number2;
            case '-':
                yield number1 - number2;
            case '*':
                yield number1 * number2;
            case '/':
                yield number1 / number2;
            case '%':
                yield number1 % number2;
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        };
        System.out.println("Result: " + calculate);
    }
}