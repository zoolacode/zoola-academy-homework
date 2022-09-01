package com.zoolatech.lecture3.tasks._2;

public class InIntervalValidator extends UserAccountFieldExtractor implements Validator {
    private  String fieldName;
    private final int x;
    private final int y;

    public InIntervalValidator(String fieldName,  int x, int y) {
        this.fieldName = fieldName;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        int fieldValue = getIntFieldValue(userAccount,fieldName);
        if (fieldValue >= x && fieldValue <= y) {
            System.out.println("Field`s " + fieldName + " value is more than " + x + " or less than " + y);
            return true;
        } else {
            System.out.println("Field`s " + fieldName + " value is not in interval " + x + "-" + y + ". Validating error.");
            return false;
        }
    }
}
