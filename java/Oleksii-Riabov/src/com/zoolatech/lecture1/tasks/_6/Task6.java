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
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;
        char operator;

        if(scanner.hasNextInt()){
            number1 = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        if(scanner.hasNextInt()){
            number2 = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        if(scanner.hasNext()){
            operator = scanner.next().charAt(0);
        } else {
            throw new IllegalArgumentException("Enter character value");
        }

        numbersEvaluationIfElseMethod(number1, number2, operator);
        numbersEvaluationCaseMethod(number1, number2, operator);
    }

    public static void numbersEvaluationIfElseMethod(int number1, int number2, char c) {
        if (c=='+') {
            printResult(number1 + number2);
        } else if (c == '-') {
            printResult(number1 - number2);
        } else if (c == '*') {
            printResult(number1 * number2);
        } else if (c == '/') {
            printResult(number1 / number2);
        } else if (c == '%') {
            printResult(number1 % number2);
        } else {
            throw new IllegalArgumentException("Enter symbol of an operation");
        }
    }

    public static void numbersEvaluationCaseMethod(int number1, int number2, char c) {
        switch (c) {
            case '+' -> printResult(number1 + number2);
            case '-' -> printResult(number1 - number2);
            case '*' -> printResult(number1 * number2);
            case '/' -> printResult(number1 / number2);
            case '%' -> printResult(number1 % number2);
            default -> throw new IllegalArgumentException("Enter symbol of an operation");
        }
    }

    public static void printResult(int result){
        System.out.println(result);
    }
}
