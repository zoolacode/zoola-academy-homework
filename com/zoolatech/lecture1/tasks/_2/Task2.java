package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**
 * Write a program that accepts a distance in meters and time in seconds and outputs a speed in meters/second and kilometers/hour.
 * The result should be a floating point number.
 **/
public class Task2 {

    public Double convertSpeedValueToMs(double distance, double time) {
        double convertedDistance = distance / time;
        return convertedDistance;
    }

    public Double convertSpeedValueToKh(double distance, double time) {
        int secondsInHour = 3600;
        int metersInKm = 1000;
        double hours = time / secondsInHour;
        double kms = distance / metersInKm;
        double calculatedValue = kms / hours;
        return calculatedValue;
    }

    void calculatedDistanceValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance, please");
        double distance = sc.nextDouble();
        System.out.println("Enter the time, please");
        double time = sc.nextDouble();
        System.out.println("Meters per second:" + convertSpeedValueToMs(distance, time));
        System.out.println("Kms per hour:" + convertSpeedValueToKh(distance, time));
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.calculatedDistanceValue();
    }
}
