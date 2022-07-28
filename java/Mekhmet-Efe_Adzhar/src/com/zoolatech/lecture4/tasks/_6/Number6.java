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
        VariationOne variationOne = new VariationOne();
        variationOne.countStringSymbolsVariationOne(string);
        VariationTwo variationTwo = new VariationTwo();
        variationTwo.countStringSymbolsVariationTwo(string);
    }
}

class VariationOne {

    public void countStringSymbolsVariationOne(String string) {
        int counterOfChars = 0;
        int counterOfDigits = 0;
        int couterForSpaces = 0;
        int counterForOtherCharacters = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i <= string.length() - 1; i++) {
                if (c == string.charAt(i)) {
                    counterOfChars++;
                }
            }
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            for (int i = 0; i <= string.length() - 1; i++) {
                if (c == string.charAt(i)) {
                    counterOfChars++;
                }
            }
        }
        System.out.print(counterOfChars + " " + "letters");
        System.out.println();

        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                counterOfDigits++;
            }
        }
        System.out.print(counterOfDigits + " " + "digits");
        System.out.println();

        for (char c : chars) {
            if (c == ' ') {
                couterForSpaces++;
            }
        }
        System.out.print(couterForSpaces + " " + "spaces");
        System.out.println();

        for (char c : chars) {
            if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)) {
                counterForOtherCharacters++;
            }
        }
        System.out.print(counterForOtherCharacters + " " + "other characters");
    }
}

class VariationTwo {

    public void countStringSymbolsVariationTwo(String string) {
        int counterOfChars = 0;
        int counterOfDigits = 0;
        int couterForSpaces = 0;
        int counterForOtherCharacters = 0;

        char[] chars = string.toCharArray();

        for (char c : chars) {
            if (Character.isLetter(c)) {
                counterOfChars++;
            } else if (Character.isDigit(c)) {
                counterOfDigits++;
            } else if (Character.isSpaceChar(c)) {
                couterForSpaces++;
            } else if (!Character.isDigit(c) && !Character.isLetter(c) && !Character.isSpaceChar(c)) {
                counterForOtherCharacters++;
            }
        }
        System.out.println(counterOfChars + " " + "letters");
        System.out.println(counterOfDigits + " " + "digits");
        System.out.println(couterForSpaces + " " + "spaces");
        System.out.println(counterForOtherCharacters + " " + "other characters");
    }
}