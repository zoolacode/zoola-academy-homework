package com.zoolatech.lecture3.tasks._2;

import java.util.List;

public class MainValidator implements Validatable {
    private List<Validator> validators;

    public MainValidator(StringIsNotEmptyValidator firstNameValidator, StringIsNotEmptyValidator secondNameValidator,
                         StringIsNotEmptyValidator countryValidator, EmailValidator emailValidator,
                         PhoneNumberValidator phoneNumberValidator, NumberIsInRangeValidator birthDayValidator,
                         NumberIsInRangeValidator birthMonthValidator, NumberIsBiggerValidator userIdValidator) {
        this.validators = List.of(firstNameValidator, secondNameValidator, countryValidator,
                emailValidator, phoneNumberValidator, birthDayValidator,
                birthMonthValidator, userIdValidator);
    }

    @Override
    public boolean isValid(UserAccount account) {
        for (Validator validator : validators) {
            if (!validator.isValid(account)) {
                return false;
            }
        }
        return true;
    }
}
