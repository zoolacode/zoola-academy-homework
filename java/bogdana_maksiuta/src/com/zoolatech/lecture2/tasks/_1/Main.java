package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

/**
 * Define a class that represents a calculator.
 * The class should provide methods that accept another value and perform addition, subtraction,
 * multiplication and division operations on a value stored in a calculator instance.
 * Divides by a zero should be forbidden and ignored. The class should also provide a method to get a current value.
 * The class should work with both integer and double numbers (ignore roundoff errors).
 * Assume all operation results fit into the range of values for a current value type.
 */
public class Main {

    public static void main(String[] args) {
        Calculator calculation = new Calculator();
        calculation.processOfCalculation();

        Scanner scanner = new Scanner(System.in);

        boolean work = true;
        while (work) {
            System.out.println("""
                                Next calculation?
                                'Y' - YES
                                'N' - NO
                                """);
            String choice = scanner.next();
            if ("Y".equals(choice)) {
                calculation.processOfCalculation();
            } else {
                System.out.println("Bye!");
                work = false;
            }
        }
    }
}

