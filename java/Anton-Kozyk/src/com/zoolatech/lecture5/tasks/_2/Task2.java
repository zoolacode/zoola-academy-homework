package com.zoolatech.lecture5.tasks._2;

import java.util.Collections;
import java.util.List;

/**
 * Create a generic method that accepts a list of values
 * (not only numbers) and returns the max value.
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(max(List.of(1, 2, 3)));
        System.out.println(max(List.of("a", "b", "c")));
        System.out.println(max(List.of('1', '2', '6')));
    }

    public static <T extends Comparable<T>> T max(List<T> array) {
        return Collections.max(array);
    }
}
