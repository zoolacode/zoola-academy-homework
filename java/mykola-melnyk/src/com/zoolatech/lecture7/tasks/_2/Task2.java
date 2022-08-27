package com.zoolatech.lecture7.tasks._2;

public class Task2 {
    public static void main(String[] args) {
        Calc_v_3 calc3 = new Calc_v_3(1);
        Calc_v_2 calc2 = new Calc_v_2(1);
        Calc_v_1 calc1 = new Calc_v_1(1);

        Runnable r_3_plus = () ->
                System.out.println( "3_plus: " + calc3.add(5));
        Runnable r_3_minus = () ->
                System.out.println("3_minus: " + calc3.subtract(5));

        Runnable r_2_plus = () ->
                System.out.println("2_plus: " + calc2.add(5));
        Runnable r_2_minus = () ->
                System.out.println("2_minus: " + calc2.subtract(5));

        Runnable r_1_plus = () ->
                System.out.println("1_plus: " + calc1.add(5));
        Runnable r_1_minus = () ->
                System.out.println("1_minus: " + calc1.subtract(5));

        var t_3_plus = new Thread(r_3_plus);
        var t_3_minus = new Thread(r_3_minus);

        var t_2_plus = new Thread(r_2_plus);
        var t_2_minus = new Thread(r_2_minus);

        var t_1_plus = new Thread(r_1_plus);
        var t_1_minus = new Thread(r_1_minus);

        t_3_plus.start();
        t_3_minus.start();
        t_2_plus.start();
        t_2_minus.start();
        t_1_plus.start();
        t_1_minus.start();
    }
}
