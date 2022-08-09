package com.zoolatech.lecture1.tasks._6;

/**
*Write a program that accepts two numbers and a symbol of an operation
*(as a character) and outputs the result of the selected operation.
*Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
*The program should work only with integer values. Create two versions of the program:
*one should use the if-else statement, second - the switch statement.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first integer number");
        int num1 = scanner.nextInt();

        System.out.println("Input second integer number");
        int num2 = scanner.nextInt();

        System.out.println("Input either of the operators: +, -, *, /, %");
        char ch = scanner.next().charAt(0);

        if (ch =='+') {
            System.out.println(num1 + num2);
        }
        else if (ch =='-') {
            System.out.println(num1 - num2);
        }
        else if (ch =='*') {
            System.out.println(num1 * num2);
        }
        else if (ch =='/') {
            System.out.println(num1 / num2);
        }
        else if (ch =='%') {
            System.out.println(num1 % num2);
        }
        else {
            System.out.println("Wrong input!");
        }


    }
}
