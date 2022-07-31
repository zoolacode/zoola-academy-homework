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

import java.util.Scanner;

public class Number4 {
    public static void main(String[] args) {
        //  String string = "Hello World";
        Number4 number4 = new Number4();
        //number4.letterCounter(string);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a String");
        String secondString = scanner.nextLine();
        number4.letterCounter(secondString);

    }

    public void letterCounter(String string) {
        int[] ints = new int[string.length()];
        char[] chars = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            ints[i] = 1;
            for (int j = i + 1; j < string.length(); j++) {
                if (chars[i] == chars[j]) {
                    ints[i]++;
                    chars[j] = 'X';
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (chars[i] != ' ' && chars[i] != 'X')
                System.out.println(chars[i] + "-" + ints[i]);
        }
    }
}