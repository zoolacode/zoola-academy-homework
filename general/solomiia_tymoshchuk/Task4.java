package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Task4 {
    String [] weekDaysArray = {"Monday","Tuesday","Wednesday","Thursday","Friday", "Saturday", "Sunday"};
    Integer [] numbers = {1,2,3,4,5};
    HashMap<Integer, String> weekDays = new HashMap<Integer, String>();

    public HashMap<Integer,String> hashOfWeekDays(){
        for (int i = 1; i < 8; i++){
            weekDays.put(i, weekDaysArray[i-1]);

        }
        System.out.println("map : " + weekDays);
        return weekDays;
    }

    public String defineMood() {
        System.out.println("Enter the digit");
        Scanner sc = new Scanner(System.in);
        Integer number = sc.nextInt();
        if(number>=8)
            {System.exit(Integer.parseInt("Incorect number"));}
        String statement = ((Arrays.asList(numbers).contains(number) ) ? "Need to go to work…" : "Sleeping…");
        System.out.println(statement);
        return statement;
    }

    public static void main (String[] args) {
        Task4 task4 = new Task4();
        task4.defineMood();
    }
}
