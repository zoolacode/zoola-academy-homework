package com.zoolatech.lecture6.tasks._3;

record UserRepository(UserCache userCache, UserTable userTable) {

    public String findUserEmail(String id) throws UserMissingException {
        return userCache.findUser(id)
                .or(() -> userTable.findUser(id))
                .map(User::email)
                .orElseThrow(() -> new UserMissingException(id));
    }
}