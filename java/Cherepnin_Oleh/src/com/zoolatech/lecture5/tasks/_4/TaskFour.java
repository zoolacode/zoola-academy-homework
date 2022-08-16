package com.zoolatech.lecture5.tasks._4;

import java.util.Map;
import java.util.TreeMap;

/**
 * Create a method that accepts a string, counts all unique non-space character occurrences and displays each character
 * with an amount of occurrences (output should be sorted by a character value in ascending order).
 * Also, add a couple of examples that use your method.
 * Input: “Hello World”
 * Output: H - 1
 * W - 1
 * d - 1
 * e - 1
 * l - 3
 * o - 2
 * r - 1
 */
public class TaskFour {
    public static void main(String[] args) {
        countCharacters("Hello World");
        System.out.println("-----------------");
        countCharacters("Aloha from Hawaii");
        System.out.println("-----------------");
        countCharacters("Good evening");
    }

    static void countCharacters(String string) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            if(aChar != ' ')
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        map.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}
