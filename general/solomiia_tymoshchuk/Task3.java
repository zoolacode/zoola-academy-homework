package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.Scanner;

public class Task3 {

    public float getFractionalPart()
    {
        System.out.println("Enter the digit");
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        float fractionalPart = number%1;
        System.out.println(fractionalPart);
        return fractionalPart;
    }

    public static void main (String[] args) {
        Task3 task3 = new Task3();
        task3.getFractionalPart();
    }
}
