package com.zoolatech.lecture6.tasks._3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cache implements UserCache {
    private List<User> cache = new ArrayList<>();

    @Override
    public Optional<User> findUser(String id) {
        return cache.stream()
                .filter(user -> user.id().equals(id))
                .findFirst();
    }

    public void addToCache(User user) {
        cache.add(user);
    }
}

interface UserCache {
    Optional<User> findUser(String id);
}
