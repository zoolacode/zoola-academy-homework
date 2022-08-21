package com.zoolatech.lecture6.tasks._3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultUserCache implements UserCache {
    private final Map<String, User> userCacheMap = new HashMap<>();

    public DefaultUserCache(User... users) {
        for (User user : users) {
            addToUserCache(user);
        }
    }

    public void addToUserCache(User user) {
        userCacheMap.put(user.id(), user);
    }

    @Override
    public Optional<User> findUser(String id) {
        return Optional.ofNullable(userCacheMap.get(id));
    }
}
