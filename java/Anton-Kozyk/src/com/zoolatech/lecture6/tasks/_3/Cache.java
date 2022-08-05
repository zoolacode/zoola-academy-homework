package com.zoolatech.lecture6.tasks._3;

import java.util.*;

public class Cache implements UserCache {
    private List<User> cache = new ArrayList<>();

    @Override
    public Optional<User> findUser(String id) {
        return cache.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public void addToCache(User user) {
        cache.add(user);
    }
}

interface UserCache {
    Optional<User> findUser(String id);
}
