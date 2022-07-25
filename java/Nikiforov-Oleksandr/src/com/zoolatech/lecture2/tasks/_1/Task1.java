package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

/**
 * Define a class that represents a calculator. The class should provide methods that
 * accept another value and perform addition, subtraction, multiplication and division
 * operations on a value stored in a calculator instance. Divides by a zero should be forbidden and ignored.
 * The class should also provide a method to get a current value. The class should work with both integer and double numbers
 * (ignore roundoff errors). Assume all operation results fit into the range of values for a current value type.
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Value to calculate: ");
        float value = sc.nextFloat();
        System.out.println("Calculator started! Input % to stop program.");
        calculation(value);
    }


    public static void calculation(float value) {
        Calculcator calculcator = new Calculcator(value);
        float number = 0, result = 0;
        while (true) {
            Scanner sc = new Scanner(System.in);
            char symbol = sc.next().charAt(0);
            switch (symbol) {
                case '+' -> {
                    System.out.println("Value to calculate: ");
                    number = sc.nextFloat();
                    result = calculcator.adding(number);
                    System.out.println("Result = " + result);
                }
                case '-' -> {
                    System.out.println("Value to calculate: ");
                    number = sc.nextFloat();
                    result = calculcator.substracting(number);
                    System.out.println("Result = " + result);
                }
                case '/' -> {
                    System.out.println("Value to calculate: ");
                    number = sc.nextFloat();
                    result = calculcator.division(number);
                    System.out.println("Result = " + result);
                }
                case '*' -> {
                    System.out.println("Value to calculate: ");
                    number = sc.nextFloat();
                    result = calculcator.multiplication(number);
                    System.out.println("Result = " + result);
                }
                case '%' -> {
                    System.out.println("Bue!");
                    return;
                }
                default -> System.out.println("Input error");
            }
        }
    }
}
