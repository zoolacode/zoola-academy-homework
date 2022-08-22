package com.zoolatech.lecture3.tasks._2;

public class EmailValidator extends AbstractSmallerValidator {

    public EmailValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        System.out.println("validating that " + fieldName + " is valid");
        if (ValidationPattern.EMAIL.getPattern().matcher(user.getEmail()).matches()) {
            return true;
        }
        printMassage();
        return false;
    }
}
