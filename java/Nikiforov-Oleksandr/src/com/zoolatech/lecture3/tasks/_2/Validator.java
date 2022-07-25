package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;

public class Validator {
    UserAccount userAccount;

    public Validator(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public boolean isValid() {
        ArrayList<ValidatorInterface> validators = new ArrayList<>();
        UserIdValidator userIdValidator = new UserIdValidator(userAccount.userId);
        validators.add(userIdValidator);
        FirstNameValidator firstNameValidator = new FirstNameValidator(userAccount.firstName);
        validators.add(firstNameValidator);
        LastNameValidator lastNameValidator = new LastNameValidator(userAccount.lastName);
        validators.add(lastNameValidator);
        CountryValidator countryValidator = new CountryValidator(userAccount.country);
        validators.add(countryValidator);
        UserEmailValidator userEmailValidator = new UserEmailValidator(userAccount.userEmail);
        validators.add(userEmailValidator);
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator(userAccount.phonenumber);
        validators.add(phoneNumberValidator);
        BirthDayValidator birthDayValidator = new BirthDayValidator(userAccount.birthDay);
        validators.add(birthDayValidator);
        BirthMonthValidator birthMonthValidator = new BirthMonthValidator(userAccount.birthMonth);
        validators.add(birthMonthValidator);

        for (ValidatorInterface validator : validators) {
            if (!validator.isValid()) {
                return false;
            }
        }

        return true;
    }
}
