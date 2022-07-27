package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;
import java.util.List;

public class MainValidator implements Validating {
    private List<Validator> validators = new ArrayList<>();
    private boolean validationResult = true;

    @Override
    public boolean isValid(UserAccount account) {
        validators.add(new StringIsNotEmptyValidator("First name"));
        validators.add(new StringIsNotEmptyValidator("Second name"));
        validators.add(new StringIsNotEmptyValidator("Country"));
        validators.add(new EmailValidator("Email"));
        validators.add(new PhoneNumberValidator("Phone number"));
        validators.add(new NumberIsInRangeValidator("Birth day"));
        validators.add(new NumberIsInRangeValidator("Birth month"));
        validators.add(new NumberIsBiggerValidator("User ID"));

        for (Validator validator : validators) {
            if (!validator.isValid(account)) {
                validationResult = false;
            }
        }

        return validationResult;
    }
}


