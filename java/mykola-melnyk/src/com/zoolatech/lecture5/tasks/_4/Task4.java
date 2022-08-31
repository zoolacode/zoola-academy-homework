package com.zoolatech.lecture5.tasks._4;

import java.util.Map;
import java.util.TreeMap;

/**
 * Create a method that accepts a string, counts all unique non-space character occurrences and
 * displays each character with an amount of occurrences (output should be sorted by a character
 * value in ascending order). Also, add a couple of examples that use your method.
 * Input: “Hello World”
 * Output: H - 1
 * W - 1
 * d - 1
 * e - 1
 * l - 3
 * o - 2
 * r - 1
 */

public class Task4 {
    private static void charOccur3(String string) {
        TreeMap<Character, Integer> myMap = new TreeMap<>();
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (ch != ' ') {
                myMap.put(ch, myMap.getOrDefault(ch, 0) + 1);
            }
        }
        customMapPrint(myMap);
    }

    private static void customMapPrint(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Task4.charOccur3("Hello World");
    }
}
