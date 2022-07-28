package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 *Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputFirstNumber = scanner.nextInt();
        int inputSecondNumber = scanner.nextInt();
        if (inputFirstNumber > inputSecondNumber){
            System.out.println(inputFirstNumber);
        }
        else if (inputSecondNumber > inputFirstNumber) {
            System.out.println(inputSecondNumber);
        }
        else {
            System.out.println("Numbers are equal");
        }
        scanner.close();
    }
}
