package com.zoolatech.lecture5.tasks._2;

import java.util.Collections;
import java.util.List;

/**
 * Create a generic method that accepts a list of values (not only numbers)
 * and returns the max value.
 * Input:  1, 5, 7, 3, 5
 * Output:
 */

public class Task2 {

    public static void main(String[] args) {
        System.out.println(maxValue(List.of(1, 5, 7, 3, 5)));
        System.out.println(maxValue(List.of("a", "B", "c", "dd")));

    }

    public static <T extends Comparable<T>> T maxValue(List<T> list) {
       return Collections.max(list);
    }
}
