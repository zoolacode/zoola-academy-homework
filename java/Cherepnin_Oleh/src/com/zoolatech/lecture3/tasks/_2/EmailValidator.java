package com.zoolatech.lecture3.tasks._2;

public class EmailValidator implements SmallerValidator {

    private String regex = "[a-z_0-9]{3,}@[a-z]{3,6}\\.[a-z]{2,4}";

    @Override
    public boolean isValid(User user) {
        if (user.getEmail().matches(regex)) {
            return true;
        }
        System.out.println("Email is invalid");
        return false;
    }


}
