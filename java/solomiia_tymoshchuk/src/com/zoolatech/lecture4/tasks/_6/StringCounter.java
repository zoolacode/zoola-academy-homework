package com.zoolatech.lecture4.tasks._6;

import java.util.Scanner;

public class StringCounter {
    private final String input;

    StringCounter(String input) {
        this.input = input;
    }

    void counter() {
        char[] arr = input.toCharArray();
        int letter = 0;
        int space = 0;
        int digit = 0;
        int other = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(arr[i])) {
                letter++;
            } else if (Character.isDigit(arr[i])) {
                digit++;
            } else if (Character.isSpaceChar(arr[i])) {
                space++;
            } else {
                other++;
            }
        }
        System.out.printf("%d letters%n", letter);
        System.out.printf("%d digits%n", digit);
        System.out.printf("%d spaces%n", space);
        System.out.printf("%d other characters%n", other);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringCounter stringCounter = new StringCounter(input);
        stringCounter.counter();
    }
}
