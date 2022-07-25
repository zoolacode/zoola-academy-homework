package com.zoolatech.lecture1.tasks._1;

import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextDouble()){
            milesInKilometers(scanner.nextDouble());
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }
    }

    public static void milesInKilometers (double miles) {
        final double MILE_IN_KILOMETER = 1.60934;
        System.out.println(miles * MILE_IN_KILOMETER);
    }
}
