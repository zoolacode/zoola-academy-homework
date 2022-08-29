package com.zoolatech.lecture6.tasks._3;

class UserRepository {
    private final UserCache userCache;
    private final UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException {
        return userCache.findUser(id)
                .or(() -> userTable.findUser(id))
                .map(User::email)
                .orElseThrow(() -> new UserMissingException(id));
    }
}