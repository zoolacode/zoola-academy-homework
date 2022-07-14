package general.solomiia_tymoshchuk;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation
 * (as a character) and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
 * The program should work only with integer values.
 * Create two versions of the program: one should use the if-else statement, second - the switch statement.
 **/
public class Task6 {
    HashMap<Integer, String> weekDays = new HashMap<Integer, String>();
    Scanner sc = new Scanner(System.in);
    double number = sc.nextDouble();
    double number1 = sc.nextDouble();
    String operator = sc.next();

    void calculateNumbersSwitchCase() {
        System.out.println("Enter two numbers");
        switch (operator) {
            case "+":
                System.out.println(number + number1);
            case "-":
                System.out.println(number - number1);
            case "*":
                System.out.println(number * number1);
            case "/":
                System.out.println(number / number1);
            case "%":
                System.out.println(number % number1);
        }
    }

    public double calculateNumbersIfWay() {

        if (Objects.equals(operator, "+")) {
            System.out.println(number + number1);
        } else if (Objects.equals(operator, "-")) {
            System.out.println(number - number1);
        } else if (Objects.equals(operator, "*")) {
            System.out.println(number * number1);
        } else if (Objects.equals(operator, "/")) {
            System.out.println(number / number1);
        } else if (Objects.equals(operator, "%")) {
            System.out.println(number % number1);
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers and the math operator");
        Task6 task6 = new Task6();
        task6.calculateNumbersIfWay();


    }
}
