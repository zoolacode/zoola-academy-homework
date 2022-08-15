package com.zoolatech.lecture1.tasks._3;

/*Write a program that accepts a double number and outputs only its fractional part
(all digits after the decimal point).*/

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Number: ");
        double numberOne = scanner.nextDouble();
        double fractionalPart;
        fractionalPart = numberOne % 1;
        System.out.println("Fractional Part = " + fractionalPart);
    }
}
