package com.zoolatech.lecture1.tasks._5;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        numberComparer(a, b);
    }


    public static void numberComparer(int a, int b){
        //compare 2 numbers
        if (a > b){
            System.out.println(a);
        } else if (a < b) {
            System.out.println(b);
        }else{
            System.out.println("Numbers are equal");
        }
    }
}
