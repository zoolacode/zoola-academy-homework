package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**
 * Write a program that accepts a distance in meters and time in seconds
 * and outputs a speed in meters/second and kilometers/hour. The result
 * should be a floating point number.
 */

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distanceInMeters;
        double timeInSeconds;

        if(scanner.hasNextFloat()){
            distanceInMeters = scanner.nextFloat();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        if(scanner.hasNextFloat()){
            timeInSeconds = scanner.nextFloat();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        getSpeedMetersSecond(distanceInMeters, timeInSeconds);
        getSpeedKilometersHour(distanceInMeters, timeInSeconds);
    }

    public static void getSpeedMetersSecond (double distanceInMeters, double timeInSeconds){
        System.out.println(distanceInMeters/timeInSeconds);
    }

    public static void getSpeedKilometersHour (double distanceInMeters, double timeInSeconds){
        final double METERS_IN_KILOMETERS = 1000;
        final double SECONDS_IN_HOUR = 3600;

        double distanceInKilometers = distanceInMeters / METERS_IN_KILOMETERS;
        double timeInHours = timeInSeconds / SECONDS_IN_HOUR;

        System.out.println(distanceInKilometers/timeInHours);
    }
}
