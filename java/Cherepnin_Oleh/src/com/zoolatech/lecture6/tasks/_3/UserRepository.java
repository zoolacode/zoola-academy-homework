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

        Optional<User> user = cache.findUser(id);
        if (user.isPresent()) {
            return user.get().getEmail();
        }
        user = table.findUser(id);
        if (user.isPresent()) {
            return user.get().getEmail();
        }
        throw new UserMissingException("User with id: " + id + " does not exist");
    }
}
