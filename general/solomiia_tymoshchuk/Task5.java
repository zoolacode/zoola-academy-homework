package general.solomiia_tymoshchuk;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 **/
public class Task5 {

    void largerNumber() {
        System.out.println("Enter two numbers");
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        float number2 = sc.nextFloat();
        Object largerNumber = number == number2 ? "Numbers are equal" : Math.max(number, number2);
        System.out.println(largerNumber);
    }

    public static void main(String[] args) {
        Task5 task5 = new Task5();
        task5.largerNumber();
    }
}
