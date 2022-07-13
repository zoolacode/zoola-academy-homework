package com.zoolatech.lecture1.tasks._2;

/**
 * Write a program that accepts a distance in meters
 * and time in seconds and outputs a speed in
 * meters/second and kilometers/hour. The result
 * should be a floating point number.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter distance in meters:");
        double meters = scanner.nextDouble();
        System.out.println("Enter time in seconds:");
        double seconds = scanner.nextDouble();
        double speedMperS = meters / seconds;
        double speedKMperS = speedMperS * 3.6;
        System.out.println("Speed in meters per second: " + speedMperS + " m/s; " +
                "Speed in kilometers per hour: " + speedKMperS + " km/hr.");


    }
}
