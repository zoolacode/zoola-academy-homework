package com.zoolatech.lecture5.tasks._2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create a generic method that accepts a list of values (not only numbers) and returns the max value.
 */


public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> intlist = new ArrayList<>(Arrays.asList(1, 5, 7, 3, 5));
        ArrayList<String> strlist = new ArrayList<>(Arrays.asList("abc", "bac", "cab", "cba"));
        System.out.println(maxValue(intlist));
        System.out.println(maxValue(strlist));
    }

    public static <T extends Comparable<T>> T maxValue(List<T> array) {
        T max = array.get(0);
        for (T t : array) {
            if (t.compareTo(max) > 0)
                max = t;
        }
        return max;
    }
}
