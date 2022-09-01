package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;

/**
 * Create a method that accepts an integer N and a variable amount of
 * other integer numbers. The method needs to return the value of the
 * Nth (1-based) smallest element in the array. Return -1 if the
 * amount of passed integers is less than N.
 */

public class Task1 {
    public static void main(String[] args) {
        System.out.println(printSmallest(4, 1, 5, 2, 3, 7));
        System.out.println(printSmallest(3, 1, 2));
    }

    public static int printSmallest(int position, int... numbers) {
        if (position > numbers.length) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[position - 1];
    }
}
