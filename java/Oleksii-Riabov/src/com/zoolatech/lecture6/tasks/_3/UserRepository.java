package com.zoolatech.lecture6.tasks._3;

public class UserRepository {

    private final UserCache userCache;
    private final UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException{
        return userCache.findUser(id).orElse(
                userTable.findUser(id).orElseThrow(() -> new UserMissingException("Can't find User with id: " + id)))
                .email();
    }
}
