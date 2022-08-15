package com.zoolatech.lecture1.tasks._5;

/*Write a program that accepts two numbers and outputs the larger number.
If numbers are equal - output “Numbers are equal”.*/

import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number : ");
        int firstNumber = scanner.nextInt();
        System.out.println("Input second number : ");
        int secondNumber = scanner.nextInt();
        if (firstNumber != secondNumber) {
            System.out.println(firstNumber > secondNumber ? firstNumber : secondNumber);
        } else {
            System.out.println("Numbers are equal");
        }
    }
}
