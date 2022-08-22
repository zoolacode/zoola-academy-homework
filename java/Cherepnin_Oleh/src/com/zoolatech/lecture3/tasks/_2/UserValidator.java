package com.zoolatech.lecture3.tasks._2;

import java.util.List;

public class UserValidator {
    private final List<SmallerValidator> VALIDATORS = List.of(
            new NameValidator("firstName"),
            new NameValidator("lastName"),
            new NameValidator("country"),
            new NumberValidator("phoneNumber"),
            new NumberInRangeValidator("birthMonth"),
            new NumberIsBiggerValidator("birthDay"),
            new NumberIsLessValidator("birthDay"),
            new EmailValidator("email"));

    public boolean isValid(User user) {
        System.out.println("Start validating user #" + user.getId());
        boolean result = true;
        for (SmallerValidator validator : VALIDATORS) {
            if (!validator.isValid(user)) {
                result = false;
            }
        }
        System.out.println(!result ? "User #" + user.getId() + " failed validation"
                : "User #" + user.getId() + " completed validation");
        return result;
    }
}
