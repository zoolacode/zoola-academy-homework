package com.zoolatech.lecture1.tasks._1;

/*
Write a program that accepts numbers of miles as a floating point number, converts it to kilometers and outputs the result.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        // read a float number
        System.out.println("Enter numbers of miles: ");
        double numbersOfMiles = scanner.nextDouble();
        double numbersOfKilometers = numbersOfMiles * 1.609344;
        System.out.println("Entered miles in kilometers: " + numbersOfKilometers);

    }
}
