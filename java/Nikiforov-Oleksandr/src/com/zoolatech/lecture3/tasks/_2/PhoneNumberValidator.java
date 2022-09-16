package com.zoolatech.lecture3.tasks._2;

public class PhoneNumberValidator extends UserAccountFieldExtractor implements Validator {
    private String fieldName;
    private static final String allowedSymbols= "+-()";

    public PhoneNumberValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        String phoneNumber = getStringFieldValue(userAccount, fieldName);
        char[] charArray = phoneNumber.toCharArray();
        for (char c : charArray) {
            if (!(Character.isDigit(c) || allowedSymbols.indexOf(c) >= 0)) {
                System.out.println("Phone number has illegal symbols. Validating error.");
                return false;
            }
        }
        System.out.println("Phone number contains only legal symbols.");
        return true;
    }
}
