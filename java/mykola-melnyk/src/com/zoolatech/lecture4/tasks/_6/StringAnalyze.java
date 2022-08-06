package com.zoolatech.lecture4.tasks._6;

import java.util.Arrays;

/**
 * Create a method that accepts a string, counts number of letters (assume only English lower and upper letters), digits, spaces and other characters and outputs this data:
 * Input: “aB?C de 42* dcd”
 * Output:
 * 	“8 letters”
 * 	“2 digits”
 * 	“3 spaces”
 * 	“2 other characters”
 */

public class StringAnalyze {
    public static void analyze(String input) {
        int length = input.length();
        char[] chars = new char[length];
        input.getChars(0, length, chars, 0);
        System.out.println(Arrays.toString(chars) + "\n" + "Char #: " + length);
        int letterCounter = 0;
        int digitCounter = 0;
        int spaceCounter = 0;
        int otherCounter = 0;
        for (char e : chars) {
            if (Character.isLetter(e)) {
                letterCounter++;
            } else if (Character.isDigit(e)) {
                digitCounter++;
            } else if (Character.isWhitespace(e)) {
                spaceCounter++;
            } else {
                otherCounter++;
            }
        }
        System.out.println(letterCounter + " letters;" + "\n" +
                            digitCounter + " digits;" + "\n" +
                            spaceCounter + " whiteSpaces;" + "\n" +
                            otherCounter + " other symbols." + "\n");
    }
}
