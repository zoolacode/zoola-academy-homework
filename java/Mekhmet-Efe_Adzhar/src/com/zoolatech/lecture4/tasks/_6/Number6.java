package com.zoolatech.lecture4.tasks._6;

/*
Create a method that accepts a string, counts number of letters (assume only English lower and upper letters),
digits, spaces and other characters and outputs this data:
Input: “aB?C de 42* dcd”
Output:
	“8 letters”
	“2 digits”
	“3 spaces”
	“2 other characters”
 */

public class Number6 {
    public static void main(String[] args) {
        String string = "aB?C de 42* dcd";
        CharCounter charCounter = new CharCounter();
        charCounter.countStringSymbolsVariationTwo(string);
    }
}

class CharCounter {

    public void countStringSymbolsVariationTwo(String string) {
        int counterOfChars = 0;
        int counterOfDigits = 0;
        int counterForSpaces = 0;
        int counterForOtherCharacters = 0;

        char[] chars = string.toCharArray();

        for (char c : chars) {
            if (Character.isLetter(c)) {
                counterOfChars++;
            } else if (Character.isDigit(c)) {
                counterOfDigits++;
            } else if (Character.isSpaceChar(c)) {
                counterForSpaces++;
            } else  {
                counterForOtherCharacters++;
            }
        }
        System.out.println(counterOfChars + " " + "letters");
        System.out.println(counterOfDigits + " " + "digits");
        System.out.println(counterForSpaces + " " + "spaces");
        System.out.println(counterForOtherCharacters + " " + "other characters");
    }
}