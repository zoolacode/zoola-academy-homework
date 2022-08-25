package com.zoolatech.lecture6.tasks._3.storage.impl;

import com.zoolatech.lecture6.tasks._3.User;
import com.zoolatech.lecture6.tasks._3.storage.UserCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserCacheImpl implements UserCache {
    private static Map<String, User> users = new HashMap();

    static {
        users.put("1", new User("1", "email1.com"));
        users.put("2", new User("2", "email2.com"));
        users.put("3", new User("3", "email3.com"));
        users.put("4", new User("4", "email4.com"));
        users.put("5", new User("5", "email5.com"));
    }

    @Override
    public Optional<User> findUser(String id) {
        return Optional.ofNullable(users.get(id));
    }

}
