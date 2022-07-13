package com.zoolatech.lecture1.tasks._1;
import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 */



public class Task1 {
    public static void main(String[] args) {
        // task solution code here
        Scanner sc = new Scanner(System.in);
        milesToKm(sc.nextFloat());
    }

    public static void milesToKm(float distance){
        // converts distance from miles to kilometers multiplied by 1.60934412
        System.out.println("Distance in km: "+ distance * 1.60934412f);
    }
}
