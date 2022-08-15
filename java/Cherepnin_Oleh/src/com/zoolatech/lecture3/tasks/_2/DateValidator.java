package com.zoolatech.lecture3.tasks._2;

public class DateValidator extends AbstractSmallerValidator {

    public DateValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        return checkMonthAndDay(user.getBirthMonth(), user.getBirthDay());
    }

    private boolean checkMonthAndDay(int month, int day) {
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
        if (days == 0) {
            System.out.println("Month is invalid \nThere are only 12 month in year");
            return false;
        }
        return checkDayOfMonth(day, days) || printMessage(month, days);
    }

    private boolean checkDayOfMonth(int day, int days) {
        return day < days;
    }


    private boolean printMessage(int month, int days) {
        System.out.println("Day is invalid \nThere are only " + days + " days in month #" + month);
        return false;
    }
}
