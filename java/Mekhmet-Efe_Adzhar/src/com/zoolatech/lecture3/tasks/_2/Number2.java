package com.zoolatech.lecture3.tasks._2;

/*
Design a class that represents a user account validator.
The validator needs to use a list of smaller validators to perform a validation of specific account fields.
All validators need to have a method isValid that accepts a user account object and returns either true or false.
The smaller validators need to accept a field name during the creation
and apply a specific validation rule to this field.
A user account validator needs to return true if all smaller validators returned true,
and false otherwise. List of user account fields:
userId (number), firstName(string), lastName(string),
country(string), userEmail (string), phoneNumber(string),
birthDay (number), birthMonth (number).
List of validation rules:
string is not empty, valid email, valid phone number, number is in the range between X and Y,
number is bigger than a value X, number is less than a value X.
You don’t need to perform actual validation, it’s enough to print smth like
“validating that fieldName is less than 10” and return true from a smaller validator.
In the main method, create a user account and user account validator objects.
The validator needs to contain all validation rules that can be applied to user account objects.
*/

import java.util.Scanner;

public class Number2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        Validator validator = new Validator();
        System.out.println("Type user id:");
        account.userId = scanner.nextInt();
        System.out.println("Type user name:");
        account.firstName = scanner.next();
        System.out.println("Type user last name:");
        account.lastName = scanner.next();
        System.out.println("Type your country");
        System.out.println("Ukraine, USA, Canada, Mexico, Poland, Germany, France, Italy, Turkey");
        account.country = scanner.next();
        System.out.println("Type user email:");
        account.userEmail = scanner.next();
        System.out.println("Type user phone number:");
        account.phoneNumber = scanner.next();
        System.out.println("Type birth day");
        account.birthDay = scanner.nextInt();
        System.out.println("And birthday month");
        account.birthMonth = scanner.nextInt();
        validator.isValid(account);
    }
}

interface Verification {
    public boolean isValid(Account account);
}

class Account {
    int userId;
    String firstName;
    String lastName;
    String country;
    String userEmail;
    String phoneNumber;
    int birthDay;
    int birthMonth;
}

class Validator implements Verification {
    userIdValidator userIdValidator = new userIdValidator();
    nameValidation nameValidation = new nameValidation();
    countryValidation countryValidation = new countryValidation();
    userEmailValidator userEmailValidator = new userEmailValidator();
    phoneNumberValidator phoneNumberValidator = new phoneNumberValidator();
    birthDayAndBirthMonthValidator birthDayAndBirthMonthValidator = new birthDayAndBirthMonthValidator();

    @Override
    public boolean isValid(Account account) {
        if (
                userIdValidator.isValid(account)
                        && nameValidation.isValid(account)
                        && countryValidation.isValid(account)
                        && userEmailValidator.isValid(account)
                        && phoneNumberValidator.isValid(account)
                        && birthDayAndBirthMonthValidator.isValid(account)
        ) {
            System.out.println("User id is: " + account.userId);
            System.out.println("User name is: " + account.firstName + " " + account.lastName);
            System.out.println("User country is: " + account.country);
            System.out.println("User email is: " + account.userEmail);
            System.out.println("User phone number is: " + account.phoneNumber);
            System.out.println("User birthday is: " + account.birthDay + "/" + account.birthMonth);
            return true;
        }
        return false;
    }
}

class userIdValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.userId > 0) {
            System.out.println("User Id is Correct");
            return true;
        }
        System.out.println("Invalid ID");
        return false;
    }
}

class nameValidation implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.firstName.length() > 0 && account.lastName.length() > 0) {
            System.out.println("User First name and Last Name are Correct");
            return true;
        } else if (account.firstName.length() == 0) {
            System.out.println("Invalid First name");
            return false;
        } else if (account.lastName.length() == 0) {
            System.out.println("Invalid Last name");
            return false;
        }
        System.out.println("Invalid user name");
        return false;
    }
}

class countryValidation implements Verification {

    @Override
    public boolean isValid(Account account) {
        switch (account.country) {
            case "Ukraine", "USA", "Canada", "Mexico", "Poland", "Germany", "France", "Italy", "Turkey" -> {
                System.out.println("Country is correct");
                return true;
            }
            default -> {
                System.out.println("No country selected");
                return false;
            }
        }
    }
}

class userEmailValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.userEmail.length() > 0) {
            for (int i = 0; i <= account.userEmail.length() - 1; i++) {
                if (account.userEmail.contains("@")) {
                    System.out.println("Email is correct");
                    return true;
                }
            }
        }
        System.out.println("Invalid Id");
        return false;
    }
}

class phoneNumberValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.phoneNumber.length() == 13) {
            for (int i = 0; i < account.phoneNumber.length(); i++) {
                if (account.phoneNumber.contains("+380")) {
                    System.out.println("Phone number is correct");
                    return true;
                }
            }
        }
        System.out.println("Invalid Phone Number");
        return false;
    }
}

class birthDayAndBirthMonthValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.birthDay != 0 && account.birthDay <= 31) {
            System.out.println("Birth Day is correct");
            if (account.birthMonth != 0 && account.birthMonth <= 12) {
                System.out.println("Birth Month is correct\n");
                return true;
            }
        }
        System.out.println("Invalid birth data");
        return false;
    }
}