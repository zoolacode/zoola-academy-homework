package com.zoolatech.lecture6.tasks._3;

import java.util.List;
import java.util.Optional;

public class UsersCacheClass implements UserCache {
    private List<User> userscache = List.of(new User("1", "user1email@gmail.com"),
            new User("1", "user1email@gmail.com"),
            new User("2", "user2email@gmail.com"),
            new User("6", "user6email@gmail.com"));

    @Override
    public Optional<User> findUser(String id) {
        return userscache.stream()
                .filter(user -> id.equals(user.id()))
                .findAny();
    }
}
