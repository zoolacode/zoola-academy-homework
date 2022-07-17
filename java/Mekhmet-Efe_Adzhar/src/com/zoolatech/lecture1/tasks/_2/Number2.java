package com.zoolatech.lecture1.tasks._2;

import java.util.Scanner;

/**Write a program that accepts a distance in meters
 * and time in seconds and outputs a speed in meters/second and kilometers/hour.
 * The result should be a floating point number.
 */

public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        number2.calculate();
    }

    private void calculate() {

        float meters;
        float seconds;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of a distance:");
        meters = scanner.nextFloat();
        System.out.println("Input time in seconds:");
        seconds = scanner.nextFloat();

        float ms = meters / seconds;
        System.out.println("Result is: " + ms + " m/s");

        float km = ms * 18 / 5;
        System.out.println("Result is: " + km + " k/h");

    }
}