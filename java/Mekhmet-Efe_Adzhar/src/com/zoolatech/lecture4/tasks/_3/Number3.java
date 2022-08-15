package com.zoolatech.lecture4.tasks._3;

import java.util.Scanner;
import java.util.function.*;
/*
Create a functional interface StringModifier with a method modify that accepts a string and returns a modified string.
In the main class create a method that accepts a string value and a lambda expression,
applies the lambda to the value and outputs the result.
In the main method create two lambda expressions that implement the interface:
one should convert all characters to the lower case,
second - to the upper case.
Both lambdas should prepend a prefix “modified: ” before the modified values(e.g., “test” -> “modified: TEST”).
Call the defined method with some string value and both lambdas.
Call the same method with two method references that just convert all characters to the lower and upper case.
 */

public class Number3 {
    public static void main(String[] args) {

        String stringOne = "hElLo";
        Function<String, String> function = string -> string + string;
        Number3 number3 = new Number3();
        number3.concatenation(stringOne, function);

        //MARK: UPPERCASE AND lowercase LAMBDAS
        StringModifier upperCase = string -> ('"' + string + "\" -> modified: \"" + string.toUpperCase());
        StringModifier lowerCase = string -> ('"' + string + "\" -> modified: \"" + string.toLowerCase());

        //MARK: //MARK: METHOD THAT ACCEPTS A STRING VALUE AND A LAMBDA EXPRESSION
        number3.transform(stringOne, lowerCase, upperCase);

        //MARK: METHOD REFERENCE
        System.out.println("Modified with method reference");
        System.out.println(number3.modifyString(stringOne, String::toUpperCase));
        System.out.println(number3.modifyString(stringOne, String::toLowerCase));


    }

    public void concatenation(String stringOne, Function<String, String> function) {
        System.out.println(function.apply(stringOne));
    }

    public void transform(String string, StringModifier lowerCase, StringModifier upperCase) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. lowercase;\n2. UPPERCASE");
        switch (scanner.nextInt()) {
            case 1 -> System.out.println(lowerCase.modify(string));
            case 2 -> System.out.println(upperCase.modify(string));
        }
    }

    public  String modifyString(String string, StringModifier stringModifier) {
        return stringModifier.modify(string);
    }

}

@FunctionalInterface
interface StringModifier {
    String modify(String string);
}