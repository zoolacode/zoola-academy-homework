package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator implements Validator{

    private final UserAccount userAccount;

    public AccountValidator(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean isValid() {
        List<Validator> validators = new ArrayList<>();
        validators.add(new NotEmpty(userAccount.firstName()));
        validators.add(new NotEmpty(userAccount.lastName()));
        validators.add(new NotEmpty(userAccount.country()));
        validators.add(new ValidEmail(userAccount.userEmail()));
        validators.add(new ValidPhoneNumber(userAccount.phoneNumber()));
        validators.add(new NumberInRange(userAccount.userId()));
        validators.add(new MoreThanX(userAccount.birthDay()));
        validators.add(new LessThanX(userAccount.birthMonth()));

        return validators.stream().allMatch(Validator::isValid);
    }
}
