package com.zoolatech.lecture1.tasks._9;

/**
 * Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.
 * Input: 12345
 * Output: 5
 * 4
 * 3
 * 2
 * 1
 */
public class TaskNine {

    public static void main(String[] args) {
        reverseInteger(183652);
    }

    public static void reverseInteger(Integer integer) {
        String[] split = String.valueOf(integer).split("");

        for (int i = 0; i < split.length; i++) {
            System.out.println(split[split.length - (i + 1)]);
        }
    }
}
