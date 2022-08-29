package com.zoolatech.lecture4.tasks._3;

/**
 * Create a functional interface StringModifier with a method modify that accepts a string and returns a modified
 * string. In the main class create a method that accepts a string value and a lambda expression, applies the lambda
 * to the value and outputs the result. In the main method create two lambda expressions that implement the interface:
 * one should convert all characters to the lower case, second - to the upper case. Both lambdas should prepend
 * a prefix “modified: ” before the modified values (e.g., “test” -> “modified: TEST”). Call the defined method
 * with some string value and both lambdas. Call the same method with two method references that just convert
 * all characters to the lower and upper case.
 */

public class Task3 {
    public static void main(String[] args) {
        StringModifier stringUp = (expression) -> {
            String modifiedExpression = expression.toUpperCase();
            return "'" + expression + "' -> modified: '" + modifiedExpression + "'";
        };
        StringModifier stringDown = (expression) -> {
            String modifiedExpression = expression.toLowerCase();
            return "'" + expression + "' -> modified: '" + modifiedExpression + "'";
        };

        String expression1 = "LonDoN IS tHe CaPItaL of GREAt britaIn";
        String expression2 = "lOreM IpSUM hAS bEEN the INDUStRy StANDarD dumMy";
        String expression3 = "tHere ARe mANY VARIAtIons oF PaSSaGES of lorEm iPsum AvAiLaBLe";

        printResult(expression1, String::toUpperCase);
        printResult(expression1, String::toLowerCase);
        printResult(expression2, String::toUpperCase);
        printResult(expression2, String::toLowerCase);
        printResult(expression3, stringUp, stringDown);
    }


    public static void printResult(String expression, StringModifier... stringModifiers) {
        for (StringModifier stringModifier : stringModifiers) {
            System.out.println(stringModifier.modify(expression));
        }
    }
}
