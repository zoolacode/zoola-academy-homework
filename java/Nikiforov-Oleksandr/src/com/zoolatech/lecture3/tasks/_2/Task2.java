package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;
import java.util.List;

/**
 * Design a class that represents a user account validator. The validator needs to use a list of smaller validators
 * to perform a validation of specific account fields. All validators need to have a method isValid that accepts
 * a user account object and returns either true or false. The smaller validators need to accept a field name
 * during the creation and apply a specific validation rule to this field. A user account validator needs
 * to return true if all smaller validators returned true, and false otherwise. List of user account fields:
 * userId (number), firstName(string), lastName(string), country(string), userEmail (string), phoneNumber(string),
 * birthDay (number), birthMonth (number). List of validation rules: string is not empty, valid email,
 * , number is in the range between X and Y, number is bigger than a value X, number is less
 * than a value X. You don’t need to perform actual validation, it’s enough to print smth like “validating
 * that fieldName is less than 10” and return true from a smaller validator. In the main method, create a user
 * account and user account validator objects. The validator needs to contain all validation rules that can be
 * applied to user account objects.
 */


public class Task2 {
    public static void main(String[] args) {
        ArrayList<Validator> validators =  new ArrayList<>(List.of(new StringValidator ("firstName"),
                new StringValidator("lastName"), new StringValidator ("country"),
                new UserEmailValidator("userEmail"), new PhoneNumberValidator("phonenumber"),
                new InIntervalValidator("birthDay",1,31), new InIntervalValidator("birthMonth",1,12),
                new LessThanXValidator("firstname", 25), new MoreThanXValidator("country", 2)));
        MainValidator mainValidator = new MainValidator(validators);
        UserAccount userAccount = new UserAccount(1, "Oleksandr", "Nikiforov", "Ukraine", "nikiforovsh@gmail.com", "0997189890", 18, 7);
        if (mainValidator.isValid(userAccount)) {
            System.out.println("Validation was successful");
        } else {
            System.out.println("Validation was not successful");
        }

        System.out.println("\n\n");
        UserAccount defectiveUser = new UserAccount(2, "Paul", "Lixx", "England", "li@x@gmail.com", "2161294", 32, 12);
        if (mainValidator.isValid(defectiveUser)) {
            System.out.println("Validation was successful");
        } else {
            System.out.println("Validation was not successful");
        }
    }
}
