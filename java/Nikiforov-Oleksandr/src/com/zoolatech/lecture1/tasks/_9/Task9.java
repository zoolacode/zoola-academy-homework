package com.zoolatech.lecture1.tasks._9;
import java.util.Scanner;

/**
 * Write a program that accepts an integer value and outputs all its
 * digits in the reverse order on a new line.
 */

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reversedDigits(sc.nextInt());
    }

    public static void reversedDigits(int number){
        //output all digits of the number in the reverse order
        while(number != 0){
            int digit = number%10;
            System.out.println(digit);
            number /= 10;
        }
    }

}
