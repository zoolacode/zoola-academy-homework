package com.zoolatech.lecture4.tasks._6;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Create a method that accepts a string, counts number of letters (assume only English lower and upper letters),
 * digits, spaces and other characters and outputs this data:
 * Input: “aB?C de 42* dcd”
 * Output:
 * “8 letters”
 * “2 digits”
 * “3 spaces”
 * “2 other characters”
 * You can use static methods of the Character class to determine if a specific character is a letter or digit
 */
public class TaskSix {
    public static void main(String[] args) {
        String str = "oLeh 203 :-) ";
        Map<String, Integer> characters = initMap();
        countSpecificCharacters(str, characters);
        characters.forEach((k, v) -> System.out.println(v + " " + k));
    }

    private static Map<String, Integer> initMap() {
        Map<String, Integer> characters = new LinkedHashMap<>();
        characters.put("letters", 0);
        characters.put("digits", 0);
        characters.put("spaces", 0);
        characters.put("other characters", 0);
        return characters;
    }

    private static void countSpecificCharacters(String str, Map<String, Integer> characters) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (Character.isAlphabetic(aChar)) {
                characters.put("letters", characters.get("letters") + 1);
            } else if (Character.isDigit(aChar)) {
                characters.put("digits", characters.get("digits") + 1);
            } else if (Character.isSpaceChar(aChar)) {
                characters.put("spaces", characters.get("spaces") + 1);
            } else {
                characters.put("other characters", characters.get("other characters") + 1);
            }
        }
    }
}
