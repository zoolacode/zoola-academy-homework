package com.zoolatech.lecture6.tasks._3;

public class UserRepository {
    private UserCache userCache;
    private UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException {
        return userCache.findUser(id).map(user -> {
                    System.out.println("Found in cache");
                    return user.email();
                })
                .orElseGet(() -> userTable
                        .findUser(id)
                        .map(user -> {
                            System.out.println("Found in user list");
                            return user.email();
                        })
                        .orElse("No user with ID '" + id + "' was found..."));
    }
}
