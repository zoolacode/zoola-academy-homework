package com.zoolatech.lecture5.tasks._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create a method that accepts a list of words, and displays only unique one (order can be random).
 * Bonus task: treat strings in a different case as the same one: “Apple” and “apple” should be treated
 * as the same string (don’t use any methods that create a new string object - like toUpperCase or
 * toLowerCase - you can work only with a given input).
 * Input: [“apple”, “orange”, “pear”, “apple”, “banana”, “orange”]
 * Output: apple
 * orange
 * pear
 * banana
 */
public class TaskThree {
    public static void main(String[] args) {
        String[] fruits = {"apple", "Apple", "orange", "orange", "pear", "peach", "Pear", "peach"};
        displayUnique(fruits);
        displayUniqueIgnoreCase(fruits);
    }

    static void displayUnique(String[] stringList) {
        List<String> distinct = Arrays.stream(stringList)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);
    }

    static void displayUniqueIgnoreCase(String[] stringArray) {
        List<String> distinct = new ArrayList<>();

        for (String str : stringArray) {
            if (!checkSimilar(distinct, str)) {
                distinct.add(str);
            }
        }
        System.out.println(distinct);
    }

    private static boolean checkSimilar(List<String> strings, String str) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            if (str.equalsIgnoreCase(iterator.next())) {
                return true;
            }
        }
        return false;
    }
}
