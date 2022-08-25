package com.zoolatech.lecture3.tasks._2;

public class NameValidator extends AbstractSmallerValidator {

    public NameValidator(String fieldName) {
        super(fieldName);
    }

    protected boolean checkField(String name) {
        System.out.println("validating that " + fieldName + " is not empty");
        if (name.isBlank()) {
            System.out.println("Field '" + fieldName + "' is blank");
        } else if (!ValidationPattern.NAME.getPattern().matcher(name).matches()) {
            printMassage();
        } else return true;
        return false;
    }

    @Override
    public boolean isValid(User user) {
        return switch (fieldName) {
            case ("firstName") -> checkField(user.getFirstName());
            case ("lastName") -> checkField(user.getLastName());
            case ("country") -> checkField(user.getCountry());
            default -> throw new IllegalArgumentException("Field does not exist");
        };
    }
}
