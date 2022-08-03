package com.zoolatech.lecture6.tasks._3;

public class UserRepository {

    private final UserCache userCache;
    private final UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException{
        if (userCache.findUser(id).isPresent()) {
            return userCache.findUser(id).get().email();
        } else if (userTable.findUser(id).isPresent()) {
            return userTable.findUser(id).get().email();
        } else {
            throw new UserMissingException("Can't find User with id: " + id);
        }
    }
}
