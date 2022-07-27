package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**
 * Write a program that accepts a distance in meters and time in seconds and outputs a
 * speed in meters/second and kilometers/hour. The result should be a floating point
 * number.
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculateSpeed(scanner.nextDouble(), scanner.nextInt());
    }

    public static void calculateSpeed(double distance, int time) {
        double speedInMS = distance / time;
        double speedInKmH = speedInMS * 3.6;
        System.out.println("Your speed is: " + speedInMS + " m/s " +
                "(or " + speedInKmH + " km/h)");
    }
}
