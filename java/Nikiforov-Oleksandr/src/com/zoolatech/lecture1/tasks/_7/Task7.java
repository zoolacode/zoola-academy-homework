package com.zoolatech.lecture1.tasks._7;
import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1. N should be read from the input.
 * Every number should be printed on the new line. Create two versions of the program:
 * one should use the for loop, second - the while loop.
 */

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0){
            n--;
        }
        oddNumbersWhile(n);
        System.out.println('\n');
        oddNumberFor(n);
    }


    public static void oddNumbersWhile(int n){
        //output all odd number, "while" version
        while (n >= 1){
            System.out.println(n);
            n-=2;
        }
    }


    public static void oddNumberFor(int n){
        //output all odd number, "for" version
        for(int i = n;i >= 1;i-=2){
            System.out.println(i);
        }
    }
}
