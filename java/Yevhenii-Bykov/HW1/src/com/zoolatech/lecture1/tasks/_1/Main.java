package com.zoolatech.lecture1.tasks._1;

import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */


public class Main {

    public static void main(String[] args) {
        float oneMilePerKm = 1.60934412f;
        Scanner scanner = new Scanner(System.in);
        float numbersOfMiles = scanner.nextFloat();
        float milePerKm = numbersOfMiles*oneMilePerKm;
        System.out.println(numbersOfMiles + "mi = " + milePerKm  + "km");
        scanner.close();
    }

}
