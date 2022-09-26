package com.zoolatech.lecture1.tasks._4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCounter {
    private final String input;

    CharCounter(String input) {
        this.input = input;
    }

    public Map<String, Long> countCharsInString() {
        Map<String, Long> map = Arrays.stream(input.split(""))
                .filter(letter -> !letter.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map;
    }

    public LinkedHashMap<String, Integer> sortedMap() {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        countCharsInString().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), Math.toIntExact(x.getValue())));
        return sortedMap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        CharCounter charCounter = new CharCounter(input);
        System.out.println(charCounter.sortedMap());
    }
}