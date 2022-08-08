package com.zoolatech.lecture5.tasks._4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
    public static void charOccur(String string) {
        string = string.replaceAll(" ", ""); // removed spaces
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        string = new String(chars);  // sorted alphabetically
        System.out.println(string);  // test, to see if the string is as we want
        HashMap<Character, Integer> charTable = new LinkedHashMap<>();  //create hashmap
        int length = string.length();
        Character ch;
        for (int i = 0; i < length; i++) {
            ch = string.charAt(i);
            if (charTable.containsKey(ch)) {
                charTable.put(ch, charTable.get(ch) + 1);
            } else {
                charTable.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charTable.entrySet()) {  // print output
            System.out.print(entry.getKey() + " - ");
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        Task4.charOccur("Hello World");
    }
}
