package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Task6 {
    HashMap<Integer, String> weekDays = new HashMap<Integer, String>();
    Scanner sc = new Scanner(System.in);
    double number = sc.nextDouble();
    double number1 = sc.nextDouble();
    String operator = sc.next();

    void calculateNumbersSwitchCase(){
        System.out.println("Enter two numbers");
        switch (operator) {
            case "+":
                System.out.println(number+number1);
            case "-":
                System.out.println(number-number1);
            case "*":
                System.out.println(number*number1);
            case "/":
                System.out.println(number/number1);
            case "%":
                System.out.println(number%number1);
        }
    }
    public double calculateNumbersIfWay()
    {

        if(Objects.equals(operator, "+")){
            System.out.println(number+number1);
        }
        else if(Objects.equals(operator, "-")){
        System.out.println(number-number1);
        }
        else if(Objects.equals(operator, "*")){
            System.out.println(number*number1);
        }
        else if(Objects.equals(operator, "/")){
            System.out.println(number/number1);
        }
        else if(Objects.equals(operator, "%")){
            System.out.println(number%number1);
        }

        return number;
    }

    public static void main (String[] args) {
        System.out.println("Enter two numbers and the math operator");
        Task6 task6 = new Task6();
        task6.calculateNumbersIfWay();


    }
}
