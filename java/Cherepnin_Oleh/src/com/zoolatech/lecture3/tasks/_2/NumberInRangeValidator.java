package com.zoolatech.lecture3.tasks._2;

public class NumberInRangeValidator extends AbstractSmallerValidator {

    public NumberInRangeValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        return checkDate(user.getBirthMonth());
    }

    private boolean checkDate(int month) {
        System.out.println("validating that " + fieldName + " is in range between 0 and 13");
        if (month > 0 && month < 13) {
            return true;
        }
        printMassage();
        return false;
    }
}
