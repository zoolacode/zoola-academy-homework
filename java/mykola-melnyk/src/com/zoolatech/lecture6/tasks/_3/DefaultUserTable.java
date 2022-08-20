package com.zoolatech.lecture6.tasks._3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultUserTable implements UserTable{
    private Map<String, String> userTableMap = new HashMap<>();

    @Override
    public Optional<User> findUser(String id) {
        return Optional.empty();
    }
}
// constructor varargs
