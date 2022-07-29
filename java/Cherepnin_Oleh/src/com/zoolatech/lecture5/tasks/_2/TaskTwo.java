package com.zoolatech.lecture5.tasks._2;

import java.util.Arrays;

/**
 * Create a generic method that accepts a list of values (not only numbers) and returns the max value.
 * Input:  1, 5, 7, 3, 5
 * Output:
 */
public class TaskTwo {
    public static void main(String[] args) {
        System.out.println(findMax(1, 4, 15, 8, 2, 15, 10, 9));
        System.out.println(findMax(1d, 4.5, 15.2, 15.45, 2D, 15.46, 10.5, 9.0));
        System.out.println(findMax("hello", "Hello", "world", "Hi", "Aloha"));
    }

    static <T extends Comparable> T findMax(T... values) {
        return Arrays.stream(values)
                .max(Comparable::compareTo)
                .get();
    }
}
