package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the operation:
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values.
 */

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculator(scanner.nextInt(), scanner.nextInt(), scanner.next().charAt(0));
        System.out.println();
        calculator2(scanner.nextInt(), scanner.nextInt(), scanner.next().charAt(0));
    }

    public static void calculator(int a, int b, char operation) {
        int result = 0;

        if (operation == '+') {
            result = a + b;
        } else if (operation == '-') {
            result = a - b;
        } else if (operation == '*') {
            result = a * b;
        } else if (operation == '%') {
            result = a % b;
        } else if (operation == '/') {
            try {
                result = a / b;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Wrong operation...");
        }

        System.out.println(result);
    }

    public static void calculator2(int a, int b, char operation) {
        int result = switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '%' -> a % b;
            case '/' -> {
                try {
                    yield a / b;
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    yield 0;
                }
            }
            default -> {
                System.out.println("Wrong operation...");
                yield 0;
            }
        };
        System.out.println(result);
    }
}
