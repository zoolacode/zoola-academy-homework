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
        Optional<User> userCache = cache.findUser(id);
        Optional<User> userTable = table.findUser(id);

        User foundUser = userCache.orElse(userTable.orElse(null));

        if (foundUser != null){
            return foundUser.email();
        }

        throw new UserMissingException("Cannot find user " + id + " in table and cache");
    }
}