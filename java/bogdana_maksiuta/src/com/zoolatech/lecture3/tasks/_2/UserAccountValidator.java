package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;

public class UserAccountValidator implements Validator {
    UserAccount userAccount;

    public UserAccountValidator(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        ArrayList<Validator> userAccountValidators = new ArrayList<>();
        userAccountValidators.add(new StringIsNotEmptyValidation(userAccount.getFirstName(),
                userAccount.getLastName(), userAccount.getCountry(), userAccount.getUserEmail(),
                userAccount.getPhoneNumber()));
        userAccountValidators.add(new EmailValidation(userAccount.getUserEmail()));
        userAccountValidators.add(new PhoneNumberValidation(userAccount.getPhoneNumber()));
        userAccountValidators.add(new NumberInTheRangeValidation(userAccount.getBirthMonth()));
        userAccountValidators.add(new NumberIsBiggerThanValueValidation(userAccount.getBirthDay()));
        userAccountValidators.add(new NumberIsLessThanValueValidation(userAccount.getBirthDay()));

        for (Validator validator : userAccountValidators) {
            if (!validator.isValid(userAccount)) {
                System.out.println("Access denied");
                return false;
            }
        }
        System.out.println("Access granted");
        return true;
    }
}
