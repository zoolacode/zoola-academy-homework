package com.zoolatech.lecture3.tasks._2;

public class UserAccountValidator implements Validator {
    IdUserValidator idUserValidator = new IdUserValidator();
    NameValidator nameValidator = new NameValidator();
    LastNameValidator lastNameValidator = new LastNameValidator();
    CountryValidator countryValidator = new CountryValidator();
    UserEmailValidator userEmailValidator = new UserEmailValidator();
    PhoneNumberValid phoneNumberValid = new PhoneNumberValid();
    BirthDay birthDay = new BirthDay();
    BirthMonth birthMonth = new BirthMonth();

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean isValid = idUserValidator.isValid(userAccount) && nameValidator.isValid(userAccount)
                && lastNameValidator.isValid(userAccount) && countryValidator.isValid(userAccount)
                && userEmailValidator.isValid(userAccount) && phoneNumberValid.isValid(userAccount)
                && birthDay.isValid(userAccount) && birthDay.isValid(userAccount)
                && birthMonth.isValid(userAccount);
        if (isValid) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
        return isValid;
    }

}

class IdUserValidator implements Validator {
    public boolean isCorrect(UserAccount userAccount) {
        System.out.println("Validating that 'id' is correct");
        return userAccount.getUserId() > 0;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return isCorrect(userAccount);
    }
}

class NameValidator implements Validator {
    public boolean isEmpty(UserAccount userAccount) {
        System.out.println("Validating that 'name' isn't empty");
        return !(userAccount.getFirstName().isEmpty());
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return isEmpty(userAccount);
    }
}

class LastNameValidator implements Validator {
    public boolean isEmpty(UserAccount userAccount) {
        System.out.println("Validating that 'last name' isn't empty");
        return !(userAccount.getLastName().isEmpty());
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return isEmpty(userAccount);
    }
}

class CountryValidator implements Validator {
    public boolean isEmpty(UserAccount userAccount) {
        System.out.println("Validating that 'country' isn't empty");
        return !(userAccount.getCountry().isEmpty());
    }

    public boolean isCountryExist(UserAccount userAccount) {
        System.out.println("Validating that country exist");
        return true;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return (isEmpty(userAccount) && isCountryExist(userAccount));
    }
}

class UserEmailValidator implements Validator {

    public boolean isEmpty(UserAccount userAccount) {
        System.out.println("Validating that 'Email' isn't empty");
        return !(userAccount.getUserEmail().isEmpty());
    }

    public boolean isValidEmail(UserAccount userAccount) {
        System.out.println("Validating that user email is valid");
        return true;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return (isEmpty(userAccount) && isValidEmail(userAccount));
    }
}

class PhoneNumberValid implements Validator {
    public boolean isEmpty(UserAccount userAccount) {
        System.out.println("Validating that 'Number' isn't empty");
        return !(userAccount.getUserEmail().isEmpty());
    }

    public boolean isNumberValid(UserAccount userAccount) {
        System.out.println("Validating that number is less than 10");
        return true;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return (isEmpty(userAccount) && isNumberValid(userAccount));
    }
}

class BirthDay implements Validator {
    public boolean isDayValid(UserAccount userAccount) {
        System.out.println("Validating that number is between 1 and 31");
        return userAccount.getBirthDay() > 0 && userAccount.getBirthDay() <= 31;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return isDayValid(userAccount);
    }
}

class BirthMonth implements Validator {
    public boolean isMonthValid(UserAccount userAccount) {
        System.out.println("Validating that number is between 1 and 12");
        return userAccount.getBirthMonth() > 0 && userAccount.getBirthMonth() <= 12;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        return isMonthValid(userAccount);
    }
}
