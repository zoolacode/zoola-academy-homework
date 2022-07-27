package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**
 * Write a program that accepts a distance in meters and time in seconds and outputs
 * a speed in meters/second and kilometers/hour. The result should be a floating point number.
 *         a. Input: 80
 *           10
 *           Output: 8.0
 * 	         28.8
 */
public class SpeedCalculator {
    public static void main(String[] args) {
        System.out.println("Введіть відстань: ");
        Scanner scanner = new Scanner(System.in);
        float distance = scanner.nextFloat();
        System.out.println("Введіть час: ");
        float time = scanner.nextFloat();

        if (distance >= 0 && time >= 0) {
            speedMeterPerSecond(distance, time);
            speedKilometerPerHour(distance, time);
        } else {
            throw new IllegalArgumentException("You entered a negative value");
        }
    }

    public static void speedMeterPerSecond (float distance, float time) {
        float speedMeterPerSecond = distance / time;
        System.out.println("Speed is " + speedMeterPerSecond + " meters/second");
    }

    public static void speedKilometerPerHour (float distance, float time) {
        final float METRIC_EQUIVALENT = 0.2777778f;
        float speedKilometerPerHour = (distance / time) / METRIC_EQUIVALENT;
        System.out.println("Speed is " + speedKilometerPerHour + " kilometers/hour");
    }
}
