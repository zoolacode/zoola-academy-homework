package com.zoolatech.lecture4.tasks._6;
/**
 *     6. Create a method that accepts a string, counts number of letters
 *     (assume only English lower and upper letters), digits, spaces and other characters and outputs this data:
 *         a. Input: “aB?C de 42* dcd”
 *            Output:
 * 	                “8 letters”
 * 	                “2 digits”
 * 	                “3 spaces”
 * 	                “2 other characters”
 * 	You can use static methods of the Character class to determine if a specific character is a letter or digit
 * 	(https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html)
 */

public class Main {
    public static void main(String[] args) {
        String input = "aB?C de 42* dcd";

        StringParsing stringParsing = new StringParsing();
        stringParsing.parsing(input);
    }
}
