package com.zoolatech.lecture3.tasks._2;

import java.awt.*;
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

//        MoreThanXValidator userIdValidator = new MoreThanXValidator(userId, userAccount.userId, 0);
//        validators.add(userIdValidator);
//
//        StringValidator firstNameStringValidator = new StringValidator(firstName, userAccount.firstName);
//        LessThanXValidator firstNameLessValidator = new LessThanXValidator(firstName, userAccount.firstName.length(), 20);
//        validators.add(firstNameStringValidator);
//        validators.add(firstNameLessValidator);
//
//        StringValidator lastNameValidator = new StringValidator(lastName, userAccount.lastName);
//        LessThanXValidator lastNameLessValidator = new LessThanXValidator(firstName, userAccount.lastName.length(), 30);
//        validators.add(lastNameValidator);
//        validators.add(lastNameLessValidator);
//
//        StringValidator countryValidator = new StringValidator(country, userAccount.country);
//        LessThanXValidator countryLessValidator = new LessThanXValidator(country, userAccount.country.length(), 40);
//        validators.add(countryValidator);
//        validators.add(countryLessValidator);
//
//        StringValidator userEmailStringValidator = new StringValidator(email, userAccount.userEmail);
//        MoreThanXValidator userEmailMoreValidator = new MoreThanXValidator(email, userAccount.userEmail.length(), 5);
//        UserEmailValidator userEmailValidator = new UserEmailValidator(userAccount.userEmail);
//        validators.add(userEmailStringValidator);
//        validators.add(userEmailMoreValidator);
//        validators.add(userEmailValidator);
//
//        StringValidator phoneNumberStringValidator = new StringValidator(phonenumber, userAccount.phonenumber);
//        LessThanXValidator phoneNumberLessValidator = new LessThanXValidator(phonenumber, userAccount.phonenumber.length(), 20);
//        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator(userAccount.phonenumber);
//        validators.add(phoneNumberStringValidator);
//        validators.add(phoneNumberLessValidator);
//        validators.add(phoneNumberValidator);
//
//        InIntervalValidator birthDayValidator = new InIntervalValidator(birthDay, userAccount.birthDay, 1, 31);
//        validators.add(birthDayValidator);
//
//        InIntervalValidator birthMonthValidator = new InIntervalValidator(birthMonth, userAccount.birthMonth, 1, 12);
//        validators.add(birthMonthValidator);
//
//        for (ValidatorInterface validator : validators) {
//            if (!validator.isValid()) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
