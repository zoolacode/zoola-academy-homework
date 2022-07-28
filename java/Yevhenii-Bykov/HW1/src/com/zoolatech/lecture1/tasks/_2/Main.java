package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**
 *Write a program that accepts a distance in meters and time in seconds
 * and outputs a speed in meters/second and kilometers/hour.
 * The result should be a floating point number.
 */

public class Main {

    public static void main(String[] args) {
        float multiplierOfMPerSToKmPerHConversion = 3.6f;
        Scanner scanner = new Scanner(System.in);
        float numbersOfMeters = scanner.nextFloat();
        float numbersOfSeconds = scanner.nextFloat();
        float metersPerSecond = numbersOfMeters/numbersOfSeconds;
        float mPerSToKmPerHConversion = metersPerSecond * multiplierOfMPerSToKmPerHConversion;
        System.out.println(numbersOfMeters/numbersOfSeconds + "\n" + mPerSToKmPerHConversion);
        scanner.close();
    }
}
