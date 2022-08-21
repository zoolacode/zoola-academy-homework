package com.zoolatech.lecture6.tasks._3;

import java.util.Optional;

public class UserRepository {
    private UserCache myUserCache;
    private UserTable myUserTable;

    public UserRepository(UserCache cache, UserTable table) {
        myUserCache = cache;
        myUserTable = table;
    }

    public String findUserEmail(String id) throws UserMissingException{
        Optional<User> cachedUser = myUserCache.findUser(id);
        if (cachedUser.isEmpty()) {
            Optional<User> tabledUser = myUserTable.findUser(id);
            if (tabledUser.isEmpty()) {
                throw new UserMissingException(id);
            } else {
                return tabledUser.get().email();
            }
        } else {
            return cachedUser.get().email();
        }
    }

}
