package com.zoolatech.lecture3.tasks._2;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator {
    public boolean isValid(UserAccount userAccount) {
        List<AccountValidator> list = new ArrayList<>();
        list.add(new NumberValidator("userId"));
        list.add(new StringValidator("firstName"));
        list.add(new StringValidator("lastName"));
        list.add(new StringValidator("country"));
        list.add(new StringValidator("userEmail"));
        list.add(new StringValidator("phoneNumber"));
        list.add(new NumberValidator("birthDay"));
        list.add(new NumberValidator("birthMonth"));

        return list.stream().allMatch(s -> s.isValid(userAccount));
    }
}
