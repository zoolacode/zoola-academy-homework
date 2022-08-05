package com.zoolatech.lecture6.tasks._3;

import java.util.*;

public class Table implements UserTable {
    private List<User> users = new ArrayList<>();

    @Override
    public Optional<User> findUser(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void addToUserList(User user) {
        users.add(user);
    }
}

interface UserTable {
    Optional<User> findUser(String id);
}
