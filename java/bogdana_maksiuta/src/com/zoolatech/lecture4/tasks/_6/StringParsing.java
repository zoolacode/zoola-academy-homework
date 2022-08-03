package com.zoolatech.lecture4.tasks._6;

public class StringParsing {
    private int letters;
    private int digits;
    private int spaces;
    private int otherCharacters;

    void parsing(String line) {
        for (int i = 0; i < line.length(); i++) {
            char element = line.charAt(i);
            if (Character.isDigit(element)) {
                digits += 1;
            } else if (Character.isLetter(element)) {
                letters += 1;
            } else if (Character.isSpaceChar(element)) {
                spaces += 1;
            } else {
                otherCharacters += 1;
            }
        }
        System.out.println("Digits = " + digits +
                "\nLetters = " + letters +
                "\nSpaces = " + spaces +
                "\nOther characters = " + otherCharacters);
    }
}
