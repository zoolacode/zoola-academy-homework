package com.zoolatech.lecture1.tasks._6;

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
        System.out.println(calculate1(7, 5, '%'));
        System.out.println(calculate1(1, 5, '+'));
        System.out.println(calculate1(1, 5, '-'));
        System.out.println(calculate1(4, 5, '*'));
        System.out.println(calculate1(10, 5, '/'));
        System.out.println(calculate1(10, 2, 'f'));
        System.out.println("---------------------------");
        System.out.println(calculate2(10, 2, '%'));
        System.out.println(calculate2(10, 2, '*'));
        System.out.println(calculate2(10, 2, '/'));
        System.out.println(calculate2(10, 2, '+'));

    }

    public static int calculate1(int a, int b, char c) {
        if (c == '+')
            return a + b;
        else if (c == '-')
            return a - b;
        else if (c == '*')
            return a * b;
        else if (c == '/')
            return a / b;
        else if (c == '%')
            return a % b;
        else System.out.println("operator: '" + c + "' does not exist");
        return 0;
    }

    public static int calculate2(int a, int b, char c) {
        int result = 0;
        switch (c) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> result = a / b;
            case '%' -> result = a % b;
            default -> System.out.println("operator: '" + c + "' does not exist");
        }
        return result;
    }
}