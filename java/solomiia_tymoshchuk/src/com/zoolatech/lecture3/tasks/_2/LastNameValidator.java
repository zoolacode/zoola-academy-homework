package com.zoolatech.lecture3.tasks._2;

import java.util.List;

public class LastNameValidator extends AccountValidator {

    public LastNameValidator(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean isValid() {
        return !lastName.isEmpty();
    }
}
