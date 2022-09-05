package com.zoolatech.lecture3.tasks._2;

/**
 * Design a class that represents a user account validator. The validator
 * needs to use a list of smaller validators to perform a validation of
 * specific account fields. All validators need to have a method isValid
 * that accepts a user account object and returns either true or false.
 * The smaller validators need to accept a field name during the creation
 * and apply a specific validation rule to this field. A user account
 * validator needs to return true if all smaller validators returned true,
 * and false otherwise. List of user account fields: userId (number),
 * firstName(string), lastName(string), country(string), userEmail (string),
 * phoneNumber(string), birthDay (number), birthMonth (number). List of
 * validation rules: string is not empty, valid email, valid phone number,
 * number is in the range between X and Y, number is bigger than a value X,
 * number is less than a value X. You don’t need to perform actual validation,
 * it’s enough to print smth like “validating that fieldName is less than 10”
 * and return true from a smaller validator. In the main method, create a
 * user account and user account validator objects. The validator needs to
 * contain all validation rules that can be applied to user account objects.
 */

public class Task2 {
    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(1, "Vasya",
                "Petrash", "Ukraine",
                "vasyapetrash@gmail.com", "0501234569",
                15, 8);

        System.out.println("\nIs user account valid: " + new AccountValidator(userAccount).isValid());
    }
}
