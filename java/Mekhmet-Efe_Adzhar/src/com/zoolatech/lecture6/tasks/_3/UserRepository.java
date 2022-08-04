package com.zoolatech.lecture6.tasks._3;

import java.util.stream.Collectors;

class UserRepository {
    UserCache userCache;
    UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException {
        if (userCache.findUser(id).isPresent()) {
            return userCache.findUser(id).stream()
                    .filter(user -> !user.getUserId().isEmpty())
                    .map(User::getEmail)
                    .collect(Collectors.toList())
                    .toString();
        } else if (userTable.findUser(id).isPresent()) {
            return userTable.findUser(id).stream()
                    .filter(user -> !user.getUserId().isEmpty())
                    .map(User::getEmail)
                    .collect(Collectors.toList())
                    .toString();
        } else {
            throw new UserMissingException();
        }
    }
}