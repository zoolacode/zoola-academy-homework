package com.zoolatech.java.solomiia_tymoshchuk.src.lecture4.tasks._7;

import java.util.HashMap;
import java.util.Scanner;

public class StringRepresentation {
    String input;

    HashMap<Character, String> numbers = new HashMap<>();

    StringRepresentation(String input) {
        this.input = input;
    }

    public HashMap<Character, String> fillMap() {
        numbers.put('0', "(zero)");
        numbers.put('1', "(one)");
        numbers.put('2', "(two)");
        numbers.put('3', "(three)");
        numbers.put('4', "(four)");
        numbers.put('5', "(five)");
        numbers.put('6', "(six)");
        numbers.put('7', "(seven)");
        numbers.put('8', "(eight)");
        numbers.put('9', "(nine)");
        return numbers;
    }

    void presentNumbersAsString() {
        char[] arr = input.toCharArray();
        for (char c : arr) {
            if (fillMap().containsKey(c)) {
                System.out.print(c + fillMap().get(c));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringRepresentation stringRepresentation = new StringRepresentation(input);
        stringRepresentation.presentNumbersAsString();
    }
}
