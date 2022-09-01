package com.zoolatech.lecture6.tasks._3.storage.impl;

import com.zoolatech.lecture6.tasks._3.User;
import com.zoolatech.lecture6.tasks._3.storage.UserTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserTableImpl implements UserTable {
    private static Map<String, User> users = new HashMap();

    static {
        users.put("4", new User("4", "email4.com"));
        users.put("5", new User("5", "email5.com"));
        users.put("6", new User("6", "email6.com"));
        users.put("7", new User("7", "email7.com"));
        users.put("8", new User("8", "email8.com"));
    }

    @Override
    public Optional<User> findUser(String id) {
        return Optional.ofNullable(users.get(id));
    }
}
