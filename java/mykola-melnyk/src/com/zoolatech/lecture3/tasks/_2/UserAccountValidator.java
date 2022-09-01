package com.zoolatech.lecture3.tasks._2;

import com.zoolatech.lecture3.tasks._2.validators.BiggerThan;
import com.zoolatech.lecture3.tasks._2.validators.StringNotEmpty;
import com.zoolatech.lecture3.tasks._2.validators.ValidEmail;
import com.zoolatech.lecture3.tasks._2.validators.Validator;
import com.zoolatech.lecture3.tasks._2.validators.ValidPhoneNumber;
import com.zoolatech.lecture3.tasks._2.validators.LessThan;
import com.zoolatech.lecture3.tasks._2.validators.NumberRangeXY;
import java.util.ArrayList;

public class UserAccountValidator implements Validator {
    private final ArrayList<Validator> validatorList = new ArrayList<>();

    public UserAccountValidator() {
        validatorList.add(new BiggerThan("userID", 0));
        validatorList.add(new StringNotEmpty("firstName"));
        validatorList.add(new StringNotEmpty("lastName"));
        validatorList.add(new StringNotEmpty("country"));
        validatorList.add(new ValidEmail("userEmail"));
        validatorList.add(new StringNotEmpty("userEmail"));
        validatorList.add(new ValidPhoneNumber("phoneNumber"));
        validatorList.add(new LessThan("birthDay", 31));
        validatorList.add(new BiggerThan("birthDay", 1));
        validatorList.add(new NumberRangeXY("birthMonth", 1, 12));
    }

    public boolean isValid(UserAccount account) {
        for (Validator validator : validatorList) {
            if (!validator.isValid(account)) {
                return false;
            }
        }
        return true;
    }


}
