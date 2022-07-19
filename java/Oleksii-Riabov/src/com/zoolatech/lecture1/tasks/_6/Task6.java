package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation. Possible characters for the
 * operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values.
 * Create two versions of the program: one should use the if-else statement,
 * second - the switch statement.
 */


public class Task6 {

    public static void main(String[] args) {

        int number1;
        int number2;
        char operator;

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);

        if(scanner1.hasNextInt()){
            number1 = scanner1.nextInt();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        if(scanner2.hasNextInt()){
            number2 = scanner2.nextInt();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        if(scanner3.hasNext()){
            operator = scanner3.next().charAt(0);
        } else {
            throw new IllegalArgumentException("Enter character value");
        }

        numbersEvaluationIfElseMethod(number1, number2, operator);
        numbersEvaluationCaseMethod(number1, number2, operator);

    }

    public static void numbersEvaluationIfElseMethod(int number1, int number2, char c) {

        if (c=='+') {
            System.out.println(number1 + number2);
        } else if (c == '-') {
            System.out.println(number1 - number2);
        } else if (c == '*') {
            System.out.println(number1 * number2);
        } else if (c == '/') {
            System.out.println(number1 / number2);
        } else if (c == '%') {
            System.out.println(number1 % number2);
        } else {
            throw new IllegalArgumentException("Enter symbol of an operation");
        }

    }

    public static void numbersEvaluationCaseMethod(int number1, int number2, char c) {

        switch (c) {
            case '+' -> System.out.println(number1 + number2);
            case '-' -> System.out.println(number1 - number2);
            case '*' -> System.out.println(number1 * number2);
            case '/' -> System.out.println(number1 / number2);
            case '%' -> System.out.println(number1 % number2);
            default -> throw new IllegalArgumentException("Enter symbol of an operation");
        }

    }
}
