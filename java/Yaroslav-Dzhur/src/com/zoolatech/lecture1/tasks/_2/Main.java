package com.zoolatech.lecture1.tasks._2;

/*
Write a program that accepts a distance in meters and time in seconds and outputs a speed in meters/second and kilometers/hour. The result should be a floating point number.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter numbers of meters: ");
        float numbersOfMeters = scanner.nextFloat();
        System.out.println("Enter numbers of seconds: ");
        float numbersOfSeconds = scanner.nextFloat();
        float metersPerSecond = numbersOfMeters / numbersOfSeconds;
        float kilometersPerSecond = (numbersOfMeters / 1000) / (numbersOfSeconds / 3600);

        System.out.println("Meters per second: " + metersPerSecond);
        System.out.println("Kilometers per second: " + kilometersPerSecond);
    }
}
