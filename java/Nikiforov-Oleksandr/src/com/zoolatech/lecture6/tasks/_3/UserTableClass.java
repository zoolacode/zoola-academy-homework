package com.zoolatech.lecture6.tasks._3;

import java.util.List;
import java.util.Optional;

public class UserTableClass implements UserTable {
    private List<User> userstable = List.of(new User("1", "user1email@gmail.com"),
            new User("1", "user1email@gmail.com"),
            new User("2", "user2email@gmail.com"),
            new User("3", "user3email@gmail.com"),
            new User("4", "user4email@gmail.com"),
            new User("5", "user5email@gmail.com"),
            new User("6", "user6email@gmail.com"));


    @Override
    public Optional<User> findUser(String id) {
        return userstable.stream()
                .filter(user -> id.equals(user.id()))
                .findAny();
    }
}
