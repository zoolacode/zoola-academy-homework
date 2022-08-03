package com.zoolatech.lecture4.tasks._7;

/**
 * 7. Create a method that accepts a string of digits and
 * after each digit appends its string representation in parentheses
 * Input: “12345”
 * Output: “1(one)2(two)3(three)4(four)5(five)”
 */
public class NumberInWord {
    void parsing(int value) {
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < String.valueOf(value).length(); i++) {
            char number = String.valueOf(value).charAt(i);

            switch (number) {
                case '0' -> newLine.append("0(zero)");
                case '1' -> newLine.append("1(one)");
                case '2' -> newLine.append("2(two)");
                case '3' -> newLine.append("3(three)");
                case '4' -> newLine.append("4(four)");
                case '5' -> newLine.append("5(five)");
                case '6' -> newLine.append("6(six)");
                case '7' -> newLine.append("7(seven)");
                case '8' -> newLine.append("8(eight)");
                case '9' -> newLine.append("9(nine)");
            }
        }
        System.out.println(newLine);
    }
}

class Main {
    public static void main(String[] args) {
        NumberInWord digitParsing = new NumberInWord();
        digitParsing.parsing(12345);
        digitParsing.parsing(3663);
    }
}

