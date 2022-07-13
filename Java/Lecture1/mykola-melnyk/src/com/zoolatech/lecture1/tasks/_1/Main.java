package com.zoolatech.lecture1.tasks._1;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter distance in miles:");
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        double miles = scanner.nextDouble();
        double km = miles * 1.609;
        System.out.println("Converted distance in km = " + km);

    }
}
