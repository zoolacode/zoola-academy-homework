package com.zoolatech.lecture1.tasks._3;
import java.util.Scanner;

/**
 * Write a program that accepts a double number and outputs only its
 * fractional part (all digits after the decimal point).
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        calculateFractional(sc.nextDouble());
    }


    public static void calculateFractional(double number){
        //calculate fractional part of number
        System.out.println(number - (int) number);
    }
}
