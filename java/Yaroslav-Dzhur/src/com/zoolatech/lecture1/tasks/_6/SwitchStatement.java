package com.zoolatech.lecture1.tasks._6;

/*
Write a program that accepts two numbers and a symbol of an operation (as a character) and
outputs the result of the selected operation. Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
The program should work only with integer values.
The switch statement version.
*/


import java.util.Scanner;

public class SwitchStatement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        System.out.println("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter second number: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter a symbol of an operation: ");
        char symbolOfOperation = scanner.next().charAt(0);



        switch (symbolOfOperation) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            case '/':
                System.out.println(firstNumber / secondNumber);
                break;
            case '%':
                System.out.println(firstNumber % secondNumber);
                break;
            default:
                System.out.println("Choose correct operation (‘+’, ‘-’, ‘*’, ‘/’, ‘%’)");
                break;
        }
    }
}