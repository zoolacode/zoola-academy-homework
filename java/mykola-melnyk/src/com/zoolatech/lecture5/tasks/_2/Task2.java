package com.zoolatech.lecture5.tasks._2;

import java.util.Arrays;

/**
 * Create a generic method that accepts a list of values (not only numbers) and returns the max value.
 * Input:  1, 5, 7, 3, 5
 * Output:
 */

public class Task2 {
    @SafeVarargs
    public static final <T extends Comparable<T>> T max(T... values) {
        Arrays.sort(values);
        return values[values.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(Task2.max(1, 2, 3, 4, 5));
        System.out.println(Task2.max("a", "b", "d", "c"));
    }
}
