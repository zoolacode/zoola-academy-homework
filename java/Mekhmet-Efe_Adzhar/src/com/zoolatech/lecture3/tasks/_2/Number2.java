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

import java.util.List;
import java.util.Scanner;

public class Number2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        StringIsNotEmpty stringIsNotEmpty = new StringIsNotEmpty();
        UserEmailValidator userEmailValidator = new UserEmailValidator();
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

        Validator validator = new Validator(numberRangeValidator,
                stringIsNotEmpty,
                stringIsNotEmpty ,
                userEmailValidator,
                phoneNumberValidator,
                numberRangeValidator);

        System.out.println("Type user id:");
        account.setUserId(scanner.nextInt());
        numberRangeValidator.isValid(account);

        System.out.println("Type user name:");
        account.setFirstName(scanner.next());
        stringIsNotEmpty.isValid(account);

        System.out.println("Type user last name:");
        account.setLastName(scanner.next());
        stringIsNotEmpty.isValid(account);

        System.out.println("Type your country");
        account.setCountry(scanner.next());
        stringIsNotEmpty.isValid(account);

        System.out.println("Type user email:");
        account.setUserEmail(scanner.next());
        userEmailValidator.isValid(account);

        System.out.println("Type user phone number:");
        account.setPhoneNumber(scanner.next());
        phoneNumberValidator.isValid(account);

        System.out.println("Type birth day");
        account.setBirthDay(scanner.nextInt());
        numberRangeValidator.isValid(account);

        System.out.println("And birthday month");
        account.setBirthMonth(scanner.nextInt());
        numberRangeValidator.isValid(account);

        validator.isValid(account);
    }
}

interface Verification {
    boolean isValid(Account account);
}

class Account {
   private int userId;
   private String firstName;
   private String lastName;
   private String country;
   private String userEmail;
   private String phoneNumber;
   private int birthDay;
   private int birthMonth;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }
}

class Validator implements Verification {
    List<Verification> verifications;

    public Validator(NumberRangeValidator userIdValidator,
                     StringIsNotEmpty nameValidation,
                     StringIsNotEmpty countryValidation,
                     UserEmailValidator userEmailValidator,
                     PhoneNumberValidator phoneNumberValidator,
                     NumberRangeValidator birthDayAndBirthMonthValidator) {
        this.verifications = List.of(userIdValidator, nameValidation, countryValidation,
                userEmailValidator, phoneNumberValidator, birthDayAndBirthMonthValidator);
    }

    @Override
    public boolean isValid(Account account) {
        for (Verification verification : verifications) {
            if (!verification.isValid(account)) {
                System.out.println("Invalid account");
                return false;
            }
        }
        System.out.println("User id is: " + account.getUserId());
        System.out.println("User name is: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("User country is: " + account.getCountry());
        System.out.println("User email is: " + account.getUserEmail());
        System.out.println("User phone number is: " + account.getPhoneNumber());
        System.out.println("User birthday is: " + account.getBirthDay() + "/" + account.getBirthMonth());
        return true;
    }
}

class UserEmailValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.getUserEmail().length() > 0) {
            for (int i = 0; i <= account.getUserEmail().length() - 1; i++) {
                if (account.getUserEmail().contains("@")) {
                    System.out.println("Email is correct");
                    return true;
                }
            }
        }
        System.out.println("Invalid Email");
        return false;
    }
}

class PhoneNumberValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (account.getPhoneNumber().length() == 13) {
            for (int i = 0; i < account.getPhoneNumber().length(); i++) {
                if (account.getPhoneNumber().contains("+380")) {
                    System.out.println("Phone number is correct");
                    return true;
                }
            }
        }
        System.out.println("Invalid Phone Number");
        return false;
    }
}

class StringIsNotEmpty implements Verification {

    @Override
    public boolean isValid(Account account) {
        if (!account.getFirstName().isEmpty() || !account.getLastName().isEmpty() || !account.getCountry().isEmpty()) {
            System.out.println("String is not Empty");
            return true;
        }
        return false;
    }
}

class NumberRangeValidator implements Verification {

    @Override
    public boolean isValid(Account account) {
        if((account.getUserId() > 0 && account.getUserId() <= 10)
                || (account.getBirthMonth() > 0 && account.getBirthMonth() <= 31)
                || (account.getBirthDay() > 0 && account.getBirthDay() <= 31)) {
            System.out.println("Validating that number is in the range between X and Y");
            return true;
        }
         else if(account.getUserId() > 10 || account.getBirthDay() > 31 || account.getBirthMonth() > 31) {
             System.out.println("Validating that number is greater than X");
             return false;
         }
         else  {
             System.out.println("Validating that number is less than X");
             return false;
         }
    }
}