package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the operation:
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values. Create two
 * versions of the program: one should use the if-else statement, second - the switch statement.
 * Input: 7
 * 5
 * +
 * Output: 12
 * Input: 7
 * 5
 * %
 * Output: 2
 */

public class TaskSix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a first number:");
        int a = scanner.nextInt();
        System.out.println("Input a second number:");
        int b = scanner.nextInt();
        System.out.println("Input an operator:");
        char operator = scanner.next().charAt(0);
        System.out.println(calculate1(a, b, operator));
//        System.out.println(calculate2(a, b, operator));
    }

    public static int calculate1(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        } else if (c == '/') {
            return a / b;
        } else if (c == '%') {
            return a % b;
        } else {
            System.out.println("operator: '" + c + "' does not exist");
            return 0;
        }
    }

    public static int calculate2(int a, int b, char c) {
        int result = switch (c) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case '%' -> a % b;
            default -> {
                System.out.println("operator: '" + c + "' does not exist");
                yield 0;
            }
        };
        return result;
    }
}