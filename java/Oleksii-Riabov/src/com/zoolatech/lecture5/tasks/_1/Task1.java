package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;

/**
 * Create a method that accepts an integer N and a variable amount
 * of other integer numbers. The method needs to return the value
 * of the Nth (1-based) smallest element in the array. Return -1
 * if the amount of passed integers is less than N.
 * Input: 4, 1, 5, 2, 3, 7
 * Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
 * Input: 3, 1, 2
 * Output: -1
 */

public class Task1 {

    public static void main(String[] args) {
        System.out.println(findMinArrElem(4, 1, 5, 2, 3, 7));
        System.out.println(findMinArrElem(3, 1, 2));
    }

    public static int findMinArrElem(int minArrElem, int... numbers) {
        if (minArrElem > numbers.length) {
            return -1;
        } else {
            Arrays.sort(numbers);
            return numbers[minArrElem -1];
        }
    }
}
