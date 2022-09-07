package com.zoolatech.lecture7.tasks._2;

public class Test_Task2 {
    public static void main(String[] args) throws InterruptedException {
        Calc_v_3 calc3 = new Calc_v_3(1);
        Calc_v_2 calc2 = new Calc_v_2(1);
        Calc_v_1 calc1 = new Calc_v_1(1);
        Test_Task2.testCalc(calc3);
        Test_Task2.testCalc(calc2);
        Test_Task2.testCalc(calc1);
    }
    public static void testCalc(Calc calc) throws InterruptedException {
        Runnable r1 = () -> {
            for (int i = 0; i < 1000000; i++) {
                calc.add(1);
            }
        };
        var t1 = new Thread(r1);
        t1.start();
        Runnable r2 = () -> {
            for (int i = 0; i < 500000; i++) {
                calc.subtract(1);
            }
        };
        var t2 = new Thread(r2);
        t2.start();
        t1.join();
        t2.join();
        System.out.println(calc.getStoredValue());
    }
}
