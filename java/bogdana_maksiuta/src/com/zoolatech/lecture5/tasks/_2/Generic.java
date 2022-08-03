package com.zoolatech.lecture5.tasks._2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Create a generic method that accepts a list of values (not only numbers) and returns the max value.
 *         a. Input:  1, 5, 7, 3, 5
 *            Output:
 */
public class Generic {
    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(1);
        listOfNumbers.add(5);
        listOfNumbers.add(7);
        listOfNumbers.add(3);
        listOfNumbers.add(5);
        System.out.println("Max value is '" + returnMaxValue(listOfNumbers) + "'");

        ArrayList<String> listOfLetters = new ArrayList<>();
        listOfLetters.add("f");
        listOfLetters.add("a");
        listOfLetters.add("w");
        listOfLetters.add("b");
        System.out.println("The last letter is '" + returnMaxValue(listOfLetters) + "'");
    }

    public static <T extends Object & Comparable<T>> T returnMaxValue (ArrayList <T> list) {
        return Collections.max(list);
    }
}
