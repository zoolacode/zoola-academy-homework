package com.zoolatech.lecture1.tasks._6;

/* Write a program that accepts two numbers and a symbol of an operation (as a character)
and outputs the result of the selected operation. Possible characters for the operation:
‘+’, ‘-’, ‘*’, ‘/’, ‘%’. The program should work only with integer values.
Second versions - the switch statement.*/

import java.util.Scanner;

public class Task_6b {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number : ");
        int firstNumber = scanner.nextInt();
        System.out.println("Input second number : ");
        int secondNumber = scanner.nextInt();
        System.out.println("Input character ( +, -, *, /, %) : ");
        char symbolCh = scanner.next().charAt(0);
        int result = 0;
        switch (symbolCh) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                result = firstNumber / secondNumber;
                break;
            case '%':
                result = firstNumber % secondNumber;
                break;
            default:
                throw new IllegalArgumentException("Invalid symbol " + symbolCh);

        }
        System.out.println(result);

    }
}
