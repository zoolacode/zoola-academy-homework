package com.zoolatech.lecture5.tasks._4;

/*
Create a method that accepts a string, counts all unique non-space character occurrences and displays each character
with an amount of occurrences (output should be sorted by a character value in ascending order).
Also, add a couple of examples that use your method.
Input: “Hello World”
Output:
H - 1
W - 1
d - 1
e - 1
l - 3
o - 2
r - 1
 */

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Number4 {
    public static void main(String[] args) {
        Number4 number4 = new Number4();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a String");
        String secondString = scanner.nextLine();
        number4.letterCounter(secondString);
    }

    public void letterCounter(String string) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] letters = string.toCharArray();

        for(char letter : letters) {
            map.put(letter, map.getOrDefault(letter, 0)+ 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() != ' ') {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }
        }
    }
}