package com.zoolatech.lecture3.tasks._2;

public class Validator implements Validating {
    @Override
    public boolean isValid(UserAccount account) {
        UserId userId = new UserId("User Id");
        FirstName firstName = new FirstName("First Name");
        LastName lastName = new LastName("Last Name");
        Country country = new Country("Country");
        UserEmail userEmail = new UserEmail("User Email");
        PhoneNumber phoneNumber = new PhoneNumber("Phone Number");
        BirthDay birthDay = new BirthDay("Birth Day");
        BirthMonth birthMonth = new BirthMonth("Birth Month");

        if (userId.isValid(account) & firstName.isValid(account) & lastName.isValid(account) &
                country.isValid(account) & userEmail.isValid(account) & phoneNumber.isValid(account) &
                birthDay.isValid(account) & birthMonth.isValid(account)) {
            System.out.println("\nAccount verified\n");
            return true;
        } else {
            System.out.println("\nLooks like something went wrong...\n");
            return false;
        }
    }
}

abstract class AbstractValidator {
    String fieldName;

    AbstractValidator(String fieldName) {
        this.fieldName = fieldName;
    }
}

class UserId extends AbstractValidator implements Validating {
    UserId(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is bigger than a 0...");
        return true;
    }
}

class FirstName extends AbstractValidator implements Validating {
    FirstName(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is not empty...");
        return true;
    }
}

class LastName extends AbstractValidator implements Validating {
    LastName(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is not empty...");
        return true;
    }
}

class Country extends AbstractValidator implements Validating {
    Country(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is not empty...");
        return true;
    }
}

class UserEmail extends AbstractValidator implements Validating {
    UserEmail(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is valid...");
        return true;
    }
}

class PhoneNumber extends AbstractValidator implements Validating {
    PhoneNumber(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is valid...");
        return true;
    }
}

class BirthDay extends AbstractValidator implements Validating {
    BirthDay(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is in the range between 1 and 31...");
        return true;
    }
}

class BirthMonth extends AbstractValidator implements Validating {
    BirthMonth(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is in the range between 1 and 12...");
        return true;
    }
}

interface Validating {
    boolean isValid(UserAccount account);
}
