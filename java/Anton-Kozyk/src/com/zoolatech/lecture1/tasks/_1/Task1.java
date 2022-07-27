package com.zoolatech.lecture1.tasks._1;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the distance in miles: ");
        milesInKm(scanner.nextDouble());
    }

    public static void milesInKm(double miles) {
        final double ONE_MILE_IN_KM = 1.60934;
        double kmInMile = miles * ONE_MILE_IN_KM;
        System.out.println(miles + " mile is " + kmInMile + " km");
    }
}
