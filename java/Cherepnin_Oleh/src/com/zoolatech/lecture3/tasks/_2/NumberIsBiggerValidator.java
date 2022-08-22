package com.zoolatech.lecture3.tasks._2;

public class NumberIsBiggerValidator extends AbstractSmallerValidator {
    public NumberIsBiggerValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        System.out.println("validating that " + fieldName + " is bigger than 0");
        if (user.getBirthDay() > 0) {
            return true;
        }
        printMassage();
        return false;
    }
}
