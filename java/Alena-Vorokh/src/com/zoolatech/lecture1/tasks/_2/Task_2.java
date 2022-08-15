package com.zoolatech.lecture1.tasks._2;

/*Write a program that accepts a distance in meters and time in seconds and outputs a speed
in meters/second and kilometers/hour. The result should be a floating point number.*/

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Meters: ");
        double numberOfMeters = scanner.nextInt();
        System.out.println("Input Seconds: ");
        double numberOfTime = scanner.nextInt();
        double speedMS;
        double speedKmH;
        speedMS = numberOfMeters / numberOfTime;
        speedKmH = speedMS * 3.6;
        System.out.println("Speed m/s = " + speedMS + "\nSpeed km/h = " + speedKmH);
    }
}