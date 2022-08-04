package general.lecture1.tasks._1;

import java.util.Scanner;

/**
 * Write a program that accepts numbers of miles as a floating point number,
 * converts it to kilometers and outputs the result.
 **/

public class Task1 {
    void convertKmsToMiles(double kms) {
        System.out.println("Enter km value, please");
        double milesValue = 1.609;
        double miles = kms * milesValue;
        System.out.println(miles);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double kms = sc.nextDouble();
        Task1 task1 = new Task1();
        task1.convertKmsToMiles(kms);
    }
}
