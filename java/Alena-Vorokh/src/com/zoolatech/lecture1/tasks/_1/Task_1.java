package com.zoolatech.lecture1.tasks._1;

/* Write a program that accepts numbers of miles as a floating point number,
converts it to kilometers and outputs the result. */
import java.util.Scanner;
public class Task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Miles: ");
        double numberOfMiles = scanner.nextDouble();
        double numberOfKilometers;
        numberOfKilometers = numberOfMiles * 1.609344;
        System.out.println("Miles = "+ numberOfMiles + "\nKilometers = " + numberOfKilometers);
    }

}


