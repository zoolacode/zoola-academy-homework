package com.zoolatech.lecture6.tasks._3;

import java.util.Optional;

public class UserRepository {
    public UserCache cache;
    public UserTable table;

    public UserRepository(UserCache cache, UserTable table) {
        this.cache = cache;
        this.table = table;
    }

    public String findUserEmail(String id) throws UserMissingException {
        Optional<User> user = cache.findUser(id);
        if (user.isPresent()) {
            return user.get().getEmail();
        }
        Optional<User> user1 = table.findUser(id);
        if (user1.isPresent()) {
            return user1.get().getEmail();
        }
        throw new UserMissingException("Cannot find user " + id + " in table and cache");
    }
}
