package general.lecture1.tasks._6;

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
    private int number;
    private int number1 ;
    private String operator;

    public Task6(int number, int number1, String operator){
        this.number = number;
        this.number1 = number1;
        this.operator = operator;
    }

    void calculateNumbersSwitchCase() {
        switch (operator) {
            case "+":
                System.out.println(number + number1);
                break;
            case "-":
                System.out.println(number - number1);
                break;
            case "*":
                System.out.println(number * number1);
                break;
            case "/":
                System.out.println(number / number1);
                break;
            case "%":
                System.out.println(number % number1);
                break;
        }
    }

    void calculateNumbersIfWay() {
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int number1 = sc.nextInt();
        String operator = sc.next();
        System.out.println("Enter two numbers and the math operator");
        Task6 task6 = new Task6(number, number1, operator);
        task6.calculateNumbersIfWay();
    }
}
