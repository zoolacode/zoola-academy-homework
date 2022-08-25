package general.solomiia_tymoshchuk.lecture_2;

import java.util.Scanner;

/**
 * Define a class that represents a calculator.
 * The class should provide methods that accept another value and
 * perform addition, subtraction, multiplication and division
 * operations on a value stored in a calculator instance.
 * Divides by a zero should be forbidden and ignored.
 * The class should also provide a method to get a current value.
 * The class should work with both integer and double numbers (ignore
 * roundoff errors). Assume all operation results fit into the range of
 * values for a current value type.
 **/

public class Calculator {
    private double number;

    public Calculator(double number){
        this.number = number;
    }

    void validateNumber(double number1, String operator){
        if(number1 == 0 && operator.equals("/")){
            throw new ArithmeticException("Divided by zero operation cannot possible");
        }
    }
    void calculateNumbersSwitchCase(double number1, String operator) {
        try{
        validateNumber(number1, operator);
        }
        catch (ArithmeticException e){
            System.out.println("Divided by zero operation cannot possible");
            return;
        }
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

    public void setNumber(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers and the math operator");
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        double number1 = sc.nextDouble();
        String operator = sc.next();
        Calculator calculator = new Calculator(number);
        calculator.calculateNumbersSwitchCase(number1, operator);
    }
}
