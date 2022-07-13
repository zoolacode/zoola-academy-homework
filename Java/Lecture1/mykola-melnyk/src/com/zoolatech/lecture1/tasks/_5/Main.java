package com.zoolatech.lecture1.tasks._5;

/**
 * Write a program that accepts two numbers
  *      and outputs the larger number.
   *     If numbers are equal - output “Numbers are equal”.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        double value1 = scanner.nextDouble();
        System.out.println("Enter second number:");
        double value2 = scanner.nextDouble();
        double largerValue = (value1 > value2)?(value1):(value2);
        if (value1==value2) {
            System.out.println("Numbers are equal");
        } else {
            System.out.println("Larger number is: " + largerValue);
        }


    }
}
