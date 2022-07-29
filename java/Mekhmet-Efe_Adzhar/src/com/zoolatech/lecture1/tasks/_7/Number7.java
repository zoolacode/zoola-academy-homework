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
        int oddNumber;
        System.out.println("Input number for-loop: ");
        oddNumber = scanner.nextInt();

        for (int i = 0; i <= oddNumber; i++) {
            int number = oddNumber-i;

            if (number % 2 != 0) {
                System.out.println(number);
            }
            if (number % 2 == 0) {
                number += 1;
            }
        }
        System.out.println("Turning of...\nDone :)");
    }

    private void allOddNumbersWhileLoopVersion() {

        Scanner scanner = new Scanner(System.in);
        int oddNumber;
        System.out.println("Input number while-loop: ");
        oddNumber = scanner.nextInt();

        while (oddNumber > 0) {

            if (oddNumber % 2 != 0) {
                System.out.println(oddNumber);
            }
            oddNumber-=1;
        }
        System.out.println("Turning of...\nDone :D");
    }
}