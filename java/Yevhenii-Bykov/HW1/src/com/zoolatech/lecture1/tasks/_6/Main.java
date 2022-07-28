package com.zoolatech.lecture1.tasks._6;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation (as a character)
 * and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
 * The program should work only with integer values.
 * Create two versions of the program:
 * one should use the if-else statement, second - the switch statement.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputFirstNumber = scanner.nextInt();
        int inputSecondNumber = scanner.nextInt();
        char operatorSymbol = scanner.next().charAt(0);
//        if (operatorSymbol == '+'){
//            System.out.println(inputFirstNumber + inputSecondNumber);
//        }
//        else if (operatorSymbol == '-') {
//            System.out.println(inputFirstNumber - inputSecondNumber);
//        }
//        else if (operatorSymbol == '*') {
//            System.out.println(inputFirstNumber * inputSecondNumber);
//        }
//        else if (operatorSymbol == '/') {
//            System.out.println(inputFirstNumber / inputSecondNumber);
//        }
//        else if (operatorSymbol == '%') {
//            System.out.println(inputFirstNumber % inputSecondNumber);
//        }
        int result = switch (operatorSymbol){
            case '+' :
                yield inputFirstNumber + inputSecondNumber;
            case '-' :
                yield inputFirstNumber - inputSecondNumber;
            case '*' :
                yield inputFirstNumber * inputSecondNumber;
            case '/' :
                yield inputFirstNumber / inputSecondNumber;
            case '%' :
                yield inputFirstNumber % inputSecondNumber;
            default:
                throw new IllegalStateException("Invalid symbol: " + operatorSymbol);
        };
        System.out.println(result);

        scanner.close();
    }
}
