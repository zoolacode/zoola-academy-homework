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
        calculator_2(scanner.nextInt(), scanner.nextInt(), scanner.next().charAt(0));
    }

    public static void calculator(int a, int b, char operation) {
        if (operation == '+') {
            System.out.println(a + b);
        } else if (operation == '-') {
            System.out.println(a - b);
        } else if (operation == '*') {
            System.out.println(a * b);
        } else if (operation == '/') {
            try {
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Wrong operation...");
        }
    }

    public static void calculator_2(int a, int b, char operation) {
        switch (operation) {
            case '+' -> System.out.println(a + b);
            case '-' -> System.out.println(a - b);
            case '*' -> System.out.println(a * b);
            case '/' -> {
                try {
                    System.out.println(a / b);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> System.out.println("Wrong operation");
        }
    }
}
