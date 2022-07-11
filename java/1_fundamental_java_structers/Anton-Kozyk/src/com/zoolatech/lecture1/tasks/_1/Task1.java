package com.zoolatech.lecture1.tasks._1;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value: ");
        milesInKm(scanner.nextDouble());
    }

    public static void milesInKm(double km) {
        System.out.println(km + " km is " + km * 0.621371 + " miles");
    }
}
