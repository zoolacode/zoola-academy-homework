package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.Scanner;

public class Task5 {

    void largerNumber(){
        System.out.println("Enter two numbers");
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        float number2 = sc.nextFloat();
        Object largerNumber = number == number2 ? "Numbers are equal" : Math.max(number, number2);
        System.out.println(largerNumber);
    }

    public static void main (String[] args) {
        Task5 task5 = new Task5();
        task5.largerNumber();
    }
}
