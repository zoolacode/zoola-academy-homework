package com.zoolatech.lecture3.tasks._2;

public class NumberIsLessValidator extends AbstractSmallerValidator {
    public NumberIsLessValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        System.out.println("validating that " + fieldName + " is less than 30");
        if (user.getBirthDay() < 30) {
            return true;
        }
        printMassage();
        return false;
    }
}
