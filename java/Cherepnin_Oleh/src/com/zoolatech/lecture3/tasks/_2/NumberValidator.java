package com.zoolatech.lecture3.tasks._2;

public class NumberValidator implements SmallerValidator {

    private String regex = "\\d{3}-\\d{3}-\\d{2}-\\d{2}";

    @Override
    public boolean isValid(User user) {
        if (user.getPhoneNumber().matches(regex)) {
            return true;
        }
        System.out.println("Phone number is invalid");
        return false;
    }


}
