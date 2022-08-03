package com.zoolatech.lecture5.tasks._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Create a generic method that accepts a list of values
 * (not only numbers) and returns the max value.
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(max(1, 2, 3));
        System.out.println(max("a", "b", "c"));
        System.out.println(max('1', '2', '6'));
    }

    public static <T extends Comparable<T>> T max(T... array) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        return Collections.max(list);
    }
}
