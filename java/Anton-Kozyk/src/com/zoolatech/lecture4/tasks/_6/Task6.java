package com.zoolatech.lecture4.tasks._6;

/**
 * Create a method that accepts a string, counts number of letters (assume
 * only English lower and upper letters), digits, spaces and other characters
 * and outputs this data.
 */

public class Task6 {
    public static void main(String[] args) {
        String str = "aB?C de 42* dcd";
        countCharacters(str);
    }

    static void countCharacters(String string) {
        int letterCounter = 0;
        int digitCounter = 0;
        int spaceCounter = 0;
        int specialSymbolsCounter = 0;

        for (char ch : string.toCharArray()) {
            if (Character.isLetter(ch)) {
                letterCounter++;
            } else if (Character.isDigit(ch)) {
                digitCounter++;
            } else if (Character.isSpaceChar(ch)) {
                spaceCounter++;
            } else {
                specialSymbolsCounter++;
            }
        }

        System.out.printf("""
                Letters: %d
                Digits: %d
                Spaces: %d
                Special characters: %d
                """, letterCounter, digitCounter, spaceCounter, specialSymbolsCounter);
    }
}
