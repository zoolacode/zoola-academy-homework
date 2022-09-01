package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;

public class MainValidator implements Validator{
    private ArrayList<Validator> validators;

    public MainValidator(ArrayList<Validator> validators) {
        this.validators = validators;

    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        for (Validator validator : validators) {
            if (!validator.isValid(userAccount)) {
                return false;
            }
        }
        return true;
    }
}
