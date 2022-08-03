package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;

/**
 * Create a method that accepts an integer N and a variable amount of other integer numbers.
 * The method needs to return the value of the Nth (1-based) smallest element in the array.
 * Return -1 if the amount of passed integers is less than N.
 *  a. Input: 4, 1, 5, 2, 3, 7
 *     Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
 *  b. Input: 3, 1, 2
 *     Output: -1
 */
public class FindMinNumber {

    int findMinNNumber(int N, int... numbers) {
        if (numbers.length < N) {
            return -1;
        } else {
            Arrays.sort(numbers);
            return numbers[N - 1];
        }
    }

    public static void main(String[] args) {
        int N = 4;
        int[] myNumbers = {1, 5, 2, 3, 7};
        FindMinNumber test1 = new FindMinNumber();
        System.out.println(test1.findMinNNumber(N, myNumbers));

        int N2 = 3;
        int[] myNumbers2 = {1, 2};
        FindMinNumber test2 = new FindMinNumber();
        System.out.println(test2.findMinNNumber(N2, myNumbers2));
    }
}

