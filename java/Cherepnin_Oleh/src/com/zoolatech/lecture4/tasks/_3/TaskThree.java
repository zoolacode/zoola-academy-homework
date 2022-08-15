package com.zoolatech.lecture4.tasks._3;

import java.util.Locale;

/**
 * Create a functional interface StringModifier with a method modify that accepts a string and returns a modified string.
 * In the main class create a method that accepts a string value and a lambda expression, applies the lambda to
 * the value and outputs the result. In the main method create two lambda expressions that implement the interface:
 * one should convert all characters to the lower case, second - to the upper case. Both lambdas should prepend
 * a prefix “modified: ” before the modified values (e.g., “test” -> “modified: TEST”). Call the defined method with
 * some string value and both lambdas. Call the same method with two method references that just convert all characters
 * to the lower and upper case.
 */
public class TaskThree {
    public static void main(String[] args) {
        show("hola", s -> s + " -> modified: " + s.toUpperCase(Locale.ROOT));
        show("ALOHA", s -> s + " -> modified: " + s.toLowerCase(Locale.ROOT));
    }

    public static void show(String str, StringModifier... modifiers) {
        for (StringModifier modifier : modifiers) {
            System.out.println(modifier.modify(str));
        }
    }
}

