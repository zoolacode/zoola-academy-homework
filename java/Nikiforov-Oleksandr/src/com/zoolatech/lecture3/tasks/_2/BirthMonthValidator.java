package com.zoolatech.lecture3.tasks._2;

public class BirthMonthValidator implements ValidatorInterface {
    private int maxMonth = 12;
    private int minMonth = 1;
    private int birthMonth;

    public BirthMonthValidator(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public boolean isValid() {
        if (birthMonth >= minMonth && birthMonth <= maxMonth) {
            System.out.println("Validating birthday is more than " + minMonth + " and less than " + maxMonth);
            return true;
        } else {
            System.out.println("Validating birthday does not lie in the gap [" + minMonth + ";" + maxMonth + "]");
            return false;
        }
    }
}
