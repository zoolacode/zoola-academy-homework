package com.zoolatech.lecture3.tasks._2;

import java.lang.reflect.Field;

public class NameValidator implements SmallerValidator {

    private String regex = "[A-Z][a-z]+";

    @Override
    public boolean isValid(User user) {
        try {
            boolean firstNameCheck = printMessage(user.getClass().getDeclaredField("firstName"), user.getFirstName());
            boolean lastNameCheck = printMessage(user.getClass().getDeclaredField("lastName"), user.getLastName());
            boolean countryCheck = printMessage(user.getClass().getDeclaredField("country"), user.getCountry());
            return firstNameCheck && lastNameCheck && countryCheck;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean printMessage(Field field, String name) {
        if (name.isBlank()) {
            System.out.println(field.getName() + " is blank");
        } else if (!name.matches(regex)) {
            System.out.println(field.getName() + " is invalid");
        } else return true;
        return false;
    }
}
