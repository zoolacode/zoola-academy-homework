package com.zoolatech.lecture1.tasks._6;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the operation:
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values. Create two versions of the program:
 * one should use the if-else statement, second - the switch statement.
 */


public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char symbol = sc.next().charAt(0);
        //calculatorIf(a,b,symbol);
        calculatorSwitch(a, b, symbol);
    }


    public static void calculatorIf(int a, int b, char symbol) {
        // calculator function, which made by if-else statement
        if (symbol == '+') {
            System.out.println(a + b);
        } else if (symbol == '-') {
            System.out.println(a - b);
        } else if (symbol == '/') {
            System.out.println(a / b);
        } else if (symbol == '*') {
            System.out.println(a * b);
        } else if (symbol == '%') {
            System.out.println(a % b);
        } else {
            System.out.println("Input error");
        }
    }


    public static void calculatorSwitch(int a, int b, char symbol) {
        int result;
        //calculator function, which made by switch statement
        switch (symbol) {
            case '+' -> {
                result  = a + b;
            }
            case '-' -> {
                result = a - b;
            }
            case '/' -> {
                result = a / b;
            }
            case '*' -> {
                result=a * b;
            }
            case '%' -> {
                result = a % b;
            }
            default -> {
                System.out.println("Input error");
                return;
            }
        }
        System.out.println(result);
    }
}