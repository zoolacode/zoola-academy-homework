package com.zoolatech.lecture6.tasks._3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultUserTable implements UserTable {
    private final Map<String, User> userTableMap = new HashMap<>();

    public DefaultUserTable(User... users) {
        for (User user : users) {
            addToUserTable(user);
        }
    }

    public void addToUserTable(User user) {
        userTableMap.put(user.id(), user);
    }

    @Override
    public Optional<User> findUser(String id) {
        return Optional.ofNullable(userTableMap.get(id));
    }
}

