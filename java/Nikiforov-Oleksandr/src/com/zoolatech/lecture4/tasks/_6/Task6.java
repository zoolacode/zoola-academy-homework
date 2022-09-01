package com.zoolatech.lecture4.tasks._6;

/**
 * Create a method that accepts a string, counts number of letters (assume only English lower and upper letters),
 * digits, spaces and other characters
 */

public class Task6 {
    public static void main(String[] args) {
        String expression1 = "Kill 36 %_54>$ amount 4";
        String expression2 = "aB?C de 42* dcd";
        countTypesCharacters(expression1);
        System.out.println();
        countTypesCharacters(expression2);
    }

    public static void countTypesCharacters(String expression) {
        int letters = 0;
        int digits = 0;
        int spaces = 0;
        int otherChar = 0;
        char[] charArray = expression.toCharArray();
        for (char c : charArray) {
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isSpaceChar(c)) {
                spaces++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                otherChar++;
            }
        }
        System.out.println(letters + " letters\n" + digits + " digits\n" + spaces + " spaces\n" + otherChar + " other characters");
    }
}
