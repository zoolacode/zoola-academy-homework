package general.solomiia_tymoshchuk;

import java.util.Scanner;

/**
 * Write a program that accepts a double number and outputs only its
 * fractional part (all digits after the decimal point).
 **/

public class Task3 {

    public float getFractionalPart() {
        System.out.println("Enter the digit");
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        float fractionalPart = number % 1;
        System.out.println(fractionalPart);
        return fractionalPart;
    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.getFractionalPart();
    }
}
