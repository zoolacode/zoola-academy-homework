package com.zoolatech.lecture3.tasks._2;

import java.util.List;

public class FirstNameValidator extends AccountValidator {

    public FirstNameValidator(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean isValid() {
        return !firstName.isEmpty();
    }

}
