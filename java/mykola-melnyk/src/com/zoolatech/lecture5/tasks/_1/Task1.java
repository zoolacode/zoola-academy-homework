package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;

/**
 * Create a method that accepts an integer N and a variable amount of other integer numbers.
 * The method needs to return the value of the Nth (1-based) smallest element in the array.
 * Return -1 if the amount of passed integers is less than N.
 * Input: 4, 1, 5, 2, 3, 7
 * Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
 * Input: 3, 1, 2
 * Output: -1
 */

public class Task1 {
    private int N;
    private int[] numbers;

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(task1.nSmallest(1, 3, 2, 1));
        System.out.println(task1.nSmallest(5, 3, 2, 1));
    }

    public int nSmallest(int N, int... numbers) {
        if (N > numbers.length) {
            return -1;
        }
        Arrays.sort(numbers);
        return numbers[N - 1];
    }

}

