package com.zoolatech.lecture1.tasks._6;
/* Write a program that accepts two numbers and a symbol of an operation (as a character)
and outputs the result of the selected operation. Possible characters for the operation:
‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values.
First versions - use the if-else statement.*/

import java.util.Scanner;

public class Task_6a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number : ");
        int firstNumber = scanner.nextInt();
        System.out.println("Input second number : ");
        int secondNumber = scanner.nextInt();
        System.out.println("Input character ( +, -, *, /, %) : ");
        char symbolCh = scanner.next().charAt(0);
        if (symbolCh == '+' ) {
            System.out.println(firstNumber + secondNumber);
        } else if (symbolCh == '-') {
            System.out.println(firstNumber - secondNumber);
        } else if (symbolCh == '*' ) {
            System.out.println(firstNumber * secondNumber);
        } else if (symbolCh == '/' ) {
            System.out.println(firstNumber / secondNumber);
        } else if (symbolCh == '%' ) {
            System.out.println(firstNumber % secondNumber);
        }

    }
}
