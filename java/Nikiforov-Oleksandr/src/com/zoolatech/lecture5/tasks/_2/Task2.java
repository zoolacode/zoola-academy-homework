package com.zoolatech.lecture5.tasks._2;

import java.util.Arrays;
import java.util.List;

/**
 * Create a generic method that accepts a list of values (not only numbers) and returns the max value.
 */


public class Task2 {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 5, 7, 3, 5);
        List<String> strList = Arrays.asList("abc", "bac", "cab", "cba");
        System.out.println(maxValue(intList));
        System.out.println(maxValue(strList));
    }

    public static <T extends Comparable<T>> T maxValue(List<T> array) {
        T max = array.get(0);
        for (T t : array) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }
}
