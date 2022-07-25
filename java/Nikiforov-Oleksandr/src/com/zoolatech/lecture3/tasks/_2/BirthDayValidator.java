package com.zoolatech.lecture3.tasks._2;

public class BirthDayValidator implements ValidatorInterface {
    private final int maxDay = 31;
    private final int minDay = 1;

    private int birthDay;

    public BirthDayValidator(int birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public boolean isValid() {
        if (birthDay >= minDay && birthDay <= maxDay) {
            System.out.println("Validating birthday is more than " + minDay + " and less than " + maxDay);
            return true;
        } else {
            System.out.println("Validating birthday does not lie in the gap [" + minDay + ";" + maxDay + "]");
            return false;
        }
    }
}
