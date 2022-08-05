package com.zoolatech.lecture6.tasks._3;

public class UserRepository {
    private UserCache userCache;
    private UserTable userTable;

    public UserRepository(UserCache userCache, UserTable userTable) {
        this.userCache = userCache;
        this.userTable = userTable;
    }

    public String findUserEmail(String id) throws UserMissingException {
        if (userCache.findUser(id).isEmpty()) {
            if (userTable.findUser(id).isEmpty()) {
                throw new UserMissingException("No user with ID '" + id + "' was found...");
            } else {
                System.out.println("<Found in user list>");
                return userTable.findUser(id).get().getEmail();
            }
        } else {
            System.out.println("<Found in cache>");
            return userCache.findUser(id).get().getEmail();
        }
    }
}
