package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**Write a program that prints all odd numbers from N to 1.
 *  N should be read from the input.
 *  Every number should be printed on the new line.
 *  Create two versions of the program:
 *  one should use the for loop, second - the while loop.
 */

public class Number7 {
    public static void main(String[] args) {
        Number7 number7 = new Number7();
        number7.allOddNumbersForLoopVersion();
        number7.allOddNumbersWhileLoopVersion();
    }

    private void allOddNumbersForLoopVersion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number for-loop: ");
        int maxNumber = scanner.nextInt();

        for (int i = maxNumber; i >= 0; i--) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        System.out.println("Turning of...\nDone :)");
    }

    private void allOddNumbersWhileLoopVersion() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number while-loop: ");
        int maxNumber = scanner.nextInt();

        while (maxNumber > 0) {

            if (maxNumber % 2 != 0) {
                System.out.println(maxNumber);
            }
            maxNumber--;
        }
        System.out.println("Turning of...\nDone :D");
    }
}