package com.zoolatech.lecture3.tasks._2;

public class StringValidator extends UserAccountFieldExtractor implements Validator {
    private final String fieldName;

    public StringValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        String fieldValue = getStringFieldValue(userAccount, fieldName);
        System.out.println("fieldValue: " + fieldValue);

        if (fieldValue.isEmpty()) {
            System.out.println("Field " + fieldName + " is empty. Validating error");
            return false;
        } else {
            System.out.println("Field " + fieldName + " is not empty");
            return true;
        }
    }
}
