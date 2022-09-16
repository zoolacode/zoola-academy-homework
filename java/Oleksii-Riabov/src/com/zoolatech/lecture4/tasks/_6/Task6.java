package com.zoolatech.lecture4.tasks._6;

/**
 * Create a method that accepts a string of digits and after each
 * digit appends its string representation in parentheses
 */

public class Task6 {
    public static void main(String[] args) {
        countNumberOfLetters("aB?C de 42* dcd");
    }

    public static void countNumberOfLetters(String string) {
        char[] chars = string.toCharArray();
        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int other = 0;

        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(chars[i])) {
                letters++;
            } else if (Character.isDigit(chars[i])) {
                digits++;
            } else if (Character.isSpaceChar(chars[i])) {
                spaces++;
            } else {
                other++;
            }
        }

        System.out.println(letters + " letters");
        System.out.println(digits + " digits");
        System.out.println(spaces + " spaces");
        System.out.println(other + " other characters");
    }
}
