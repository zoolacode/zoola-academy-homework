package com.zoolatech.lecture6.tasks._3;

import com.zoolatech.lecture6.tasks._3.storage.UserCache;
import com.zoolatech.lecture6.tasks._3.storage.UserTable;

import java.util.Optional;

public class UserRepository {
    private UserCache cache;
    private UserTable table;

    public UserRepository(UserCache cache, UserTable table) {
        this.cache = cache;
        this.table = table;
    }

    public String findUserEmail(String id) throws UserMissingException {

        return cache.findUser(id)
                .map(User::email)
                .orElse(table.findUser(id)
                        .map(User::email)
                        .orElseThrow(() -> new UserMissingException("User with id: " + id + " does not exist")));
    }
}
